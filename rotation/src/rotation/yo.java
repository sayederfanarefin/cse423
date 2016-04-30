/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotation;


import static java.lang.Thread.sleep;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

/**
 *
 * @author erfan
 */
public class yo implements GLEventListener{

    /**
     * @param args the command yo arguments
     */
    
    
    static GLProfile profile=GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    static GLCanvas glcanvas = new GLCanvas(capabilities);
   
    static int i=0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        yo l=new yo();
        
        glcanvas.setSize(800, 800);
        
        final JFrame frame = new JFrame ("rotate lab");
       frame.getContentPane().add(glcanvas);
       frame.setSize(frame.getContentPane().getPreferredSize());
       frame.setVisible(true);   
       
       glcanvas.addGLEventListener(l);
    }

    @Override
    public void init(GLAutoDrawable glad) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        glad.getGL().setSwapInterval(1);
    }

    @Override
    public void dispose(GLAutoDrawable glad) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
   
    }

    @Override
    public void display(GLAutoDrawable xx) {
      draw_it(xx);
      angle_update();
       while(true){
           xx.swapBuffers();
            display(xx);
       }    
    }
    public static void angle_update(){
        i=i+1;
    }
    public static void draw_it(GLAutoDrawable glad){
         final GL2 gl = glad.getGL().getGL2();
         gl.glClear(GL2.GL_COLOR_BUFFER_BIT);    
        float x0=.0f;
        float x1=.6f;
    	float y0=.0f;
        float y1=.6f;
        double angle_theta=Math.toRadians(i);
        double new_x0=x0*Math.cos(angle_theta)-y0*Math.sin(angle_theta);
    	double new_y0=y0*Math.cos(angle_theta)+x0*Math.sin(angle_theta);
    	double new_x1=x1*Math.cos(angle_theta)-y1*Math.sin(angle_theta);
    	double new_y1=y1*Math.cos(angle_theta)+x1*Math.sin(angle_theta);
        gl.glBegin(GL2.GL_LINES);
    	gl.glVertex2d(new_x0,new_y0);
        gl.glVertex2d(new_x1,new_y1);
        gl.glEnd();
          
    }
    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
