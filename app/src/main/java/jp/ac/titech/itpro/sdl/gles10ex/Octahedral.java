package jp.ac.titech.itpro.sdl.gles10ex;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Octahedral implements SimpleRenderer.Obj {

    private final static float[] VERTICES = {
            // topleft
            -1, 0, -1,
            0, 1, 0,
            -1, 0, 1,
            // topright
            1, 0, -1,
            0, 1, 0,
            1, 0, 1,
            // topback
            -1, 0, -1,
            0, 1, 0,
            1, 0, -1,
            // topfront
            -1, 0, 1,
            0, 1, 0,
            1, 0, 1,
            // bottomleft
            -1, 0, -1,
            0, -1, 0,
            -1, 0, 1,
            // bottomright
            1, 0, -1,
            0, -1, 0,
            1, 0, 1,
            // bottomback
            -1, 0, -1,
            0, -1, 0,
            1, 0, -1,
            // bottomfront
            -1, 0, 1,
            0, -1, 0,
            1, 0, 1
    };

    private final FloatBuffer vbuf;

    Octahedral() {
        vbuf = ByteBuffer.allocateDirect(VERTICES.length * 4)
                .order(ByteOrder.nativeOrder()).asFloatBuffer();
        vbuf.put(VERTICES);
        vbuf.position(0);
    }

    @Override
    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // topleft
        gl.glNormal3f(-1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);

        // topright
        gl.glNormal3f(1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 6, 3);

        // topback
        gl.glNormal3f(0, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 9, 3);

        // topfront
        gl.glNormal3f(0, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 12, 3);

        // bottomleft
        gl.glNormal3f(-1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 15, 3);

        // bottomright
        gl.glNormal3f(1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 18, 3);

        // bottomback
        gl.glNormal3f(0, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 21, 3);

        // bottomfront
        gl.glNormal3f(0, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 24, 3);
    }
}
