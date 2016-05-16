package enib.otun;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * Created by Ludo on 16/12/2015.
 */
public class Bluetooth {
    private byte out[];
    private BluetoothDevice remoteDevice;
    private BluetoothAdapter blueAdapter;
    private static final UUID uuid =
            UUID.fromString("fa87c0d0-afac-11de-8a39-0800200c9a66");
    private BluetoothServerSocket serverSocket;

    private int mState;


    public static final int STATE_NONE = 0;       // we're doing nothing
    public static final int STATE_LISTEN = 1;     // now listening for incoming connections
    public static final int STATE_CONNECTING = 2; // now initiating an outgoing connection
    public static final int STATE_CONNECTED = 3;  // now connected to a remote device



    public Bluetooth(){
        blueAdapter = BluetoothAdapter.getDefaultAdapter();

    }

    private void setState(int state) {
        mState = state;
    }

    private void setOut(byte[] buffer){
        this.out=buffer;

    }

    public byte[] getOut(){
        return this.out;
    }

    public BluetoothDevice getDeviceFromAddr(String addr){return blueAdapter.getRemoteDevice(addr);}

    public BluetoothDevice getRemoteDeviced(){return this.remoteDevice;}

    public void clientConnect(BluetoothDevice device, byte[] out) {
        blueAdapter.enable();
        setState(STATE_CONNECTING);
        final BluetoothSocket mSocket;
        final BluetoothDevice mDevice =device;
        BluetoothSocket tmp = null;

        try {
            tmp = device.createRfcommSocketToServiceRecord(uuid);
        } catch (IOException e) {

        }
        mSocket = tmp;
        blueAdapter.cancelDiscovery();
        try {
            mSocket.connect();
        } catch (IOException e) {
            // Close the socket
            try {
                mSocket.close();
            } catch (IOException e2) {

            }
        }
        connected(mSocket, out);


    }

    public void startServeur(){
        blueAdapter.enable();
        BluetoothServerSocket tmp = null;
        try {

            tmp = blueAdapter.listenUsingRfcommWithServiceRecord("bluetoothchannel",
                    uuid);
        } catch (IOException e){
        }
        setState(STATE_LISTEN);
        serverSocket = tmp;
        BluetoothSocket socket = null;
        while (mState != STATE_CONNECTED) {
            try {
                // This is a blocking call and will only return on a
                // successful connection or an exception
                socket = serverSocket.accept();
            } catch (IOException e) {

                break;
            }
            if (socket != null) {
                switch (mState) {
                    case STATE_LISTEN:
                    case STATE_CONNECTING:
                        // Situation normal. Start the connected thread.
                        connected(socket,null);
                        break;
                    case STATE_NONE:
                    case STATE_CONNECTED:
                        try {
                            socket.close();
                        } catch (IOException e) {

                        }
                        break;
                }
            }

        }



    }

    private void connected(BluetoothSocket socket,byte[] out) {
        setState(STATE_CONNECTED);
        BluetoothSocket mSocket = socket;
        final InputStream mmInStream;
        final OutputStream mmOutStream;
        InputStream tmpIn = null;
        OutputStream tmpOut = null;

        // Get the BluetoothSocket input and output streams
        try {
            tmpIn = socket.getInputStream();
            tmpOut = socket.getOutputStream();
        } catch (IOException e) {

        }

        mmInStream = tmpIn;
        mmOutStream = tmpOut;


        if (out != null) {
            try {
                mmOutStream.write(out);
            } catch (IOException e) {

            }
        } else {
            byte[] buffer = new byte[1024];
            int bytes;

            while (true) {
                try {
                    // Read from the InputStream
                    bytes = mmInStream.read(buffer);
                } catch (IOException e) {
                    break;
                }
                if (bytes >= 9) {
                    break;
                }
            }
            remoteDevice = socket.getRemoteDevice();
            try {
                mSocket.close();
            } catch (IOException e) {
            }
            setOut(buffer);
        }


    }

    public void stop(){
        blueAdapter.disable();
    }


}
