
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

import com.jogamp.opengl.util.Animator;


public class SimpleAnime implements GLEventListener {

    private double theta = 0;
    private double s = 0;
    private double c = 0;
    public static Animator animator;
    public static void main(String[] args) {
    	SimpleAnime s= new SimpleAnime();
        GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        caps.setDoubleBuffered(true);
        GLCanvas canvas = new GLCanvas(caps);
        canvas.addGLEventListener(s);
        JFrame frame = new JFrame("Animating triangle");
        frame.setSize(300, 300);
        frame.add(canvas);
        frame.setVisible(true);
      
        canvas.addGLEventListener(new SimpleAnime());
        animator = new Animator(canvas);
        animator.start();
    }

    @Override
    public void display(GLAutoDrawable drawable) {
    	theta += 0.01;
        s = Math.sin(theta);
        c = Math.cos(theta);
        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
      
        // draw a triangle filling the window
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glColor3f(1, 0, 0);
        gl.glVertex3d(-c, -c, -c);
        gl.glColor3f(0, 1, 0);
        gl.glVertex3d(0, c,c);
        gl.glColor3f(0, 0, 1);
        gl.glVertex3d(s, -s,s);
        gl.glEnd();
    }

  
    public void dispose(GLAutoDrawable drawable) {
    	
    }

   
    public void init(GLAutoDrawable drawable) {
    	drawable.getGL().setSwapInterval(1);
    }

    
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
    }

   
}
