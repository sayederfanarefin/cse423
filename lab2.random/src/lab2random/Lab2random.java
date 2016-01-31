/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2random;

import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.swing.JFrame;


public class Lab2random{
	static float[][] points = new float[100][4];
        static int counter=10000;
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
        static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
   public static void main(String[] args) {
              
              xx l = new xx();
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(800, 600);
	      
	      final JFrame frame = new JFrame ("Lab2 random");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
              
	   }
 
   static class xx  implements GLEventListener{
    
    
      public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
       	  gl.glBegin (GL2.GL_POINTS);//static field
          
          for(int ix=0;ix<counter;ix++){
   

              float x0 = aaaa();
     float x1 = aaaa();
     float y0 = aaaa();
     float y1 = aaaa();
          float dx= x1-x0;
          float dy=y1-y0;
          if(Math.abs(dy) >= Math.abs(dx)){
              //zone 1,2,5,6
              //dy>dx
              
              
              if(dx>0 && dy >0){
                  //1
                  while(y0<y1){
                  y0=y0+0.001f;
                  x0=x0+0.001f;
                  gl.glColor3d(0.2, 1, 0.4);
                  gl.glVertex2d(x0,y0);
                  }
                  
                  System.out.print("for points: ");
                  System.out.print(x0);
                  System.out.print(", ");
                  System.out.print(x1);
                  System.out.print(", ");
                  System.out.print(y0);
                  System.out.print(", ");
                  System.out.print(y1);
                  System.out.print(" ->zone: 1");
                  System.out.println();
              }
              else if(dx>0 && dy <0){
                  //6
                  while(y0>y1){
                  y0=y0-0.001f;
                  x0=x0+0.001f;
                  gl.glColor3d(0.5, 0, 1);
                  gl.glVertex2d(x0,y0);
                  }
                  System.out.print("for points: ");
                  System.out.print(x0);
                  System.out.print(", ");
                  System.out.print(x1);
                  System.out.print(", ");
                  System.out.print(y0);
                  System.out.print(", ");
                  System.out.print(y1);
                  System.out.print(" ->zone: 6");System.out.println();
              }
              else if(dx<0 && dy >0){
                  //2
                  while(y0<y1){
                  y0=y0+0.001f;
                  x0=x0-0.001f;
                  gl.glColor3d(0.9, 2, 1.4);
                  gl.glVertex2d(x0,y0);
                  }
                  System.out.print("for points: ");
                  System.out.print(x0);
                  System.out.print(", ");
                  System.out.print(x1);
                  System.out.print(", ");
                  System.out.print(y0);
                  System.out.print(", ");
                  System.out.print(y1);
                  System.out.print(" ->zone: 2");
                  System.out.println();
              }
              else if(dx<0 && dy <0){
                  //5
                  while(y0>y1){
                  y0=y0-0.001f;
                  x0=x0-0.001f;
                  gl.glColor3d(1,1,1);
                  gl.glVertex2d(x0,y0);
                  }
                  System.out.print("for points: ");
                  System.out.print(x0);
                  System.out.print(", ");
                  System.out.print(x1);
                  System.out.print(", ");
                  System.out.print(y0);
                  System.out.print(", ");
                  System.out.print(y1);
                  System.out.print(" ->zone: 5");
                  System.out.println();
              }
          }else{
              //zone 0,3,4,7
              //dy>dx
              if(dx>0 && dy >0){
                  //0
                  while(x0<x1){
                  y0=y0+0.001f;
                  x0=x0+0.001f;
                  gl.glColor3d(1, 1, 0.4);
                  gl.glVertex2d(x0,y0);
                  }
                  System.out.print("for points: ");
                  System.out.print(x0);
                  System.out.print(", ");
                  System.out.print(x1);
                  System.out.print(", ");
                  System.out.print(y0);
                  System.out.print(", ");
                  System.out.print(y1);
                  System.out.print(" ->zone: 0");
                  System.out.println();
              }
             else if(dx>0 && dy <0){
                  //7
                  while(x0<x1){
                  y0=y0-0.001f;
                  x0=x0+0.001f;
                  gl.glColor3d(0.6, 0.6, 0.6);
                  gl.glVertex2d(x0,y0);
                  }
                  System.out.print("for points: ");
                  System.out.print(x0);
                  System.out.print(", ");
                  System.out.print(x1);
                  System.out.print(", ");
                  System.out.print(y0);
                  System.out.print(", ");
                  System.out.print(y1);
                  System.out.print(" ->zone: 7");
                  System.out.println();
              }
             else if(dx<0 && dy >0){
                  //3
                  while(x0>x1){
                  y0=y0+0.001f;
                  x0=x0-0.001f;
                  gl.glColor3d(0.9, 0.9, 0.5);
                  gl.glVertex2d(x0,y0);
                  }
                  System.out.print("for points: ");
                  System.out.print(x0);
                  System.out.print(", ");
                  System.out.print(x1);
                  System.out.print(", ");
                  System.out.print(y0);
                  System.out.print(", ");
                  System.out.print(y1);
                  System.out.print(" ->zone: 3");
                  System.out.println();
              }
             else if(dx<0 && dy <0){
                  //4
                  while(x0>x1){
                  y0=y0-0.001f;
                  x0=x0-0.001f;
                  gl.glColor3d(1, .8, 0.4);
                  gl.glVertex2d(x0,y0);
                  }
                  System.out.print("for points: ");
                  System.out.print(x0);
                  System.out.print(", ");
                  System.out.print(x1);
                  System.out.print(", ");
                  System.out.print(y0);
                  System.out.print(", ");
                  System.out.print(y1);
                  System.out.print(" ->zone: 4");
                  System.out.println();
              }
          }
          }
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
   public float aaaa(){
       float max =1f;
       float min=-1f;
   
   
   float range = (max - min);     
   return (float)(Math.random() * range) + min;
   }
}
}//end of classimport javax.media.opengl.GL2;