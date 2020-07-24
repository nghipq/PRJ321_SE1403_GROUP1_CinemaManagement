/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package until;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 *
 * @author phamq
 */
public class download {

    public static long stream(InputStream input, OutputStream output) throws IOException {

        try (ReadableByteChannel inputChannel = Channels.newChannel(input); WritableByteChannel outputChannel = Channels.newChannel(output)) {
            ByteBuffer buffer = ByteBuffer.allocate(10240);
            long size = 0;

            while (inputChannel.read(buffer) != -1) {
                buffer.flip();
                size += outputChannel.write(buffer);
                buffer.clear();
            }
            return size;
        }
    }
}
