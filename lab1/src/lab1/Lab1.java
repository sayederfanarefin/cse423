/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.swing.JFrame;


public class Lab1 implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  
	      
	      Lab1 l = new Lab1();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 400);
	      
	      final JFrame frame = new JFrame ("straight Line");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      
	   }
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
      //float xx = 0.1f;
     for (float xx = 0.0f; xx<0.5f;xx=xx+.001f){
       	  gl.glBegin (GL2.GL_POINTS);//static field
          
          for (float i=-xx;i<xx;i=(float) (i+0.001)){
              gl.glVertex2d(xx,i);
          }
          for (float i=-xx;i<xx;i=(float) (i+0.001)){
              gl.glVertex2d(i,xx);
          }
          for (float i=xx;i>=-xx;i=(float) (i-0.001)){
              gl.glVertex2d(-xx,i);
          }
          for (float i=xx;i>=-xx;i=(float) (i-0.001)){
              gl.glVertex2d(i,-xx);
          }
     }
          /*gl.glVertex2d(0.5f,0.5f);
          gl.glVertex2d(0.5f,-0.5f);
          gl.glVertex2d(-0.5f,0.5f);
          gl.glVertex2d(-0.5f,-0.5f);*/
          gl.glEnd();
          
      
   }
   
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }

   
   public void init(GLAutoDrawable drawable) {
      // method body
	   //4. drive the display() in a loop
	    }
   
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   //end of main
}//end of classimport javax.media.opengl.GL2;