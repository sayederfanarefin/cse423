/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotation_cube_animator;


import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.FPSAnimator;
import java.util.Scanner;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;
/**
 *
 * @author astha
 */
public class yo2 implements GLEventListener{

     static GLProfile profile=GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    static GLCanvas glcanvas = new GLCanvas(capabilities);
  
    static int newZone;
    static double rotate=0;
    public static void main(String[] args) {
        // TODO code application logic here
        //Scanner line=new Scanner(System.in);
        // newZone=0;
        
        yo2 l=new yo2();
        glcanvas.addGLEventListener(l);
        glcanvas.setSize(600, 400);
        
       final JFrame frame = new JFrame ("straight Line");
       frame.getContentPane().add(glcanvas);
       frame.setSize(frame.getContentPane().getPreferredSize());
       frame.setVisible(true);
       
        FPSAnimator animator = new FPSAnimator(glcanvas, 60);
        //animator.add(glcanvas);
        animator.start();
       
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
      
    }
    public static void increase(){
         newZone+=10.0;
    }

    public void init(GLAutoDrawable glad) {
       //glad.getGL().setSwapInterval(1);
        glad.getGL().setSwapInterval(Integer.BYTES);
    }

    public void dispose(GLAutoDrawable glad) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void display(GLAutoDrawable glad) {
        
        increase();
        rend(glad);
        
        //gl.glEnd();
    }
    
    public static void rend(GLAutoDrawable glad){
        final GL2 gl = glad.getGL().getGL2();
       // gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
       
        double x0=.5f,x1=.8f,x2=.6f,x3=.3f,x4=.3f,x5=.6f,x6=.5f,x7=.8f;
    	double y0=.7f,y1=.7f,y2=.5f,y3=.5f,y4=.2f,y5=.2f,y6=.4f,y7=.4f;
          
	//gl.glBegin (GL2.GL_LINES);  
    	
        /*gl.glVertex2d(.8,0);
        gl.glVertex2d(-.8,0);
        
        gl.glVertex2d(0,.8);
        gl.glVertex2d(0,-.8);*/

          gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
          
        
          
          transform(gl, x0, y0, x1, y1, newZone);
          transform(gl, x0, y0, x3, y3, newZone);
          transform(gl, x2, y2, x3, y3, newZone);
          transform(gl, x2, y2, x1, y1, newZone);
          //transform(gl, x1, y1, x2, y2, newZone);
          transform(gl, x1, y1, x7, y7, newZone);
          //transform(gl, x3, y3, x0, y0, newZone);
          transform(gl, x3, y3, x4, y4, newZone);
          transform(gl, x6, y6, x0, y0, newZone);
          transform(gl, x6, y6, x4, y4, newZone);
          transform(gl, x6, y6, x7, y7, newZone);
          transform(gl, x4, y4, x5, y5, newZone);
          transform(gl, x5, y5, x2, y2, newZone);
          transform(gl, x5, y5, x7, y7, newZone);
          transform(gl, x6, y6, x7, y7, newZone);
          //transform(gl, x3, y3, x4, y4, newZone);
        
         
          
              
          
    }
    
    public static void transform(GL2 gl,double px0,double py0,double  px1,double  py1, double t){
        
	double angle=Math.toRadians(t);
        double xx0,xx1,yy0,yy1;

        xx0 = px0*Math.cos(angle) - py0*Math.sin(angle);
    	yy0 = py0*Math.cos(angle) + px0*Math.sin(angle);
    	xx1 = px1*Math.cos(angle) - py1*Math.sin(angle);
    	yy1 = py1*Math.cos(angle) + px1*Math.sin(angle);
        
        gl.glBegin(GL2.GL_LINES);
        
    	gl.glVertex2d(xx0,yy0);
        gl.glVertex2d(xx1,yy1);
        
       
        gl.glEnd();
         
        
    }

    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
