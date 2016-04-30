/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotation_cube_animator;



import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.FPSAnimator;
import static java.lang.Thread.sleep;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
import static java.lang.Thread.sleep;

/**
 *
 * @author erfan
 */
public class yo2 implements GLEventListener{

    /**
     * @param args the command yo2 arguments
     */
    
    
    static GLProfile profile=GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    static GLCanvas glcanvas = new GLCanvas(capabilities);
   
    static int i=0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        yo2 l=new yo2();
        
        glcanvas.setSize(800, 600);
        
        final JFrame frame = new JFrame ("animator lab");
       frame.getContentPane().add(glcanvas);
       frame.setSize(frame.getContentPane().getPreferredSize());
       frame.setVisible(true);   
       FPSAnimator animator = new FPSAnimator(glcanvas, 60);
        //animator.add(glcanvas);
        animator.start();
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
       
    }
    public static void angle_update(){
        i=i+3;
    }
    public static void draw_it(GLAutoDrawable glad){
         final GL2 gl = glad.getGL().getGL2();
         gl.glClear(GL2.GL_COLOR_BUFFER_BIT);    
         double px0=.3, py0=.2;
        double px1=.5, py1=.4;
        double px6=.8, py6=.7;
        double px7=.6, py7=.5;
        
        double x0=px0, y0=py0;
        double x1=px1, y1=py1;
        double x2=px7, y2=py0;
        double x3=px6, y3=py1;
        double x4=px0, y4=py7;
        double x5=px1, y5=py6;
        double x6=px6, y6=py6;
        double x7=px7, y7=py7;
        
        
        double angle_theta=Math.toRadians(i);
        double new_x0=x0*Math.cos(angle_theta)-y0*Math.sin(angle_theta);
    	double new_y0=y0*Math.cos(angle_theta)+x0*Math.sin(angle_theta);
        
    	double new_x1=x1*Math.cos(angle_theta)-y1*Math.sin(angle_theta);
    	double new_y1=y1*Math.cos(angle_theta)+x1*Math.sin(angle_theta);
        
        double new_x2=x2*Math.cos(angle_theta)-y2*Math.sin(angle_theta);
    	double new_y2=y2*Math.cos(angle_theta)+x2*Math.sin(angle_theta);
        
        double new_x3=x3*Math.cos(angle_theta)-y3*Math.sin(angle_theta);
    	double new_y3=y3*Math.cos(angle_theta)+x3*Math.sin(angle_theta);
        
        double new_x4=x4*Math.cos(angle_theta)-y4*Math.sin(angle_theta);
    	double new_y4=y4*Math.cos(angle_theta)+x4*Math.sin(angle_theta);
        
        double new_x5=x5*Math.cos(angle_theta)-y5*Math.sin(angle_theta);
    	double new_y5=y5*Math.cos(angle_theta)+x5*Math.sin(angle_theta);
        
        double new_x6=x6*Math.cos(angle_theta)-y6*Math.sin(angle_theta);
    	double new_y6=y6*Math.cos(angle_theta)+x6*Math.sin(angle_theta);
        
        double new_x7=x7*Math.cos(angle_theta)-y7*Math.sin(angle_theta);
    	double new_y7=y7*Math.cos(angle_theta)+x7*Math.sin(angle_theta);
        
        
        gl.glBegin(GL2.GL_LINES);
    	gl.glVertex2d(new_x0,new_y0);
        gl.glVertex2d(new_x1,new_y1);
        
        gl.glVertex2d(new_x1,new_y1);
        gl.glVertex2d(new_x5,new_y5);
        
        gl.glVertex2d(new_x1,new_y1);
        gl.glVertex2d(new_x3,new_y3);
        
        gl.glVertex2d(new_x0,new_y0);
        gl.glVertex2d(new_x2,new_y2);
        
        gl.glVertex2d(new_x2,new_y2);
        gl.glVertex2d(new_x3,new_y3);
        
        gl.glVertex2d(new_x0,new_y0);
        gl.glVertex2d(new_x4,new_y4);
        
        gl.glVertex2d(new_x4,new_y4);
        gl.glVertex2d(new_x5,new_y5);
        
        gl.glVertex2d(new_x5,new_y5);
        gl.glVertex2d(new_x6,new_y6);
        
        gl.glVertex2d(new_x3,new_y3);
        gl.glVertex2d(new_x6,new_y6);
        
        gl.glVertex2d(new_x4,new_y4);
        gl.glVertex2d(new_x7,new_y7);
        
        gl.glVertex2d(new_x6,new_y6);
        gl.glVertex2d(new_x7,new_y7);
        
        gl.glVertex2d(new_x2,new_y2);
        gl.glVertex2d(new_x7,new_y7);
        
        gl.glEnd();
          
    }
    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
