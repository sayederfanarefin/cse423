/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midpoint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.swing.JFrame;


public class yo{
	static float[][] points = new float[100][4];
        static int counter=0;
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
        static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
   public static void main(String[] args) {
       //creating frame
              
	      BufferedReader br = null;	      
		try {
			String sCurrentLine;

			br = new BufferedReader(new FileReader("C:\\Users\\erfan\\Desktop\\a.txt"));
                        
			while ((sCurrentLine = br.readLine()) != null) {
                             String [] temp_points= sCurrentLine.split(",");
                            
                          for(int i =0;i<4;i++){
                              points[counter][i] = Float.parseFloat(temp_points[i]);
                              //System.out.println(points[counter][i]);
                          } 
                          counter++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
                xx l = new xx();
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(800, 600);
	      
	      final JFrame frame = new JFrame ("Lab 2");
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
              float x0 = points[ix][0];
     float x1 = points[ix][1];
     float y0 = points[ix][2];
     float y1 = points[ix][3];
          float dx= x1-x0;
          float dy=y1-y0;
         
          if(Math.abs(dy) >= Math.abs(dx)){
              //zone 1,2,5,6
              //dy>dx
              //y loop controller
              if(dx>0 && dy >0){
                  //1
                  float dinit = dy-2*dx;
                  float ne = dy-2*dx;
                  float n = -2*dx;
                  while(y0<y1){
                      if(dinit>0){
                          y0=y0+0.01f;
                          dinit = dinit + n;
                      }else{
                          y0=y0+0.01f;
                          x0=x0+0.01f;
                          dinit = dinit + ne;
                      }
                  
                  gl.glColor3d(0.2, 1, 0.4);
                  gl.glVertex2d(x0,y0);
                  }
                  
                  pointsPrinter(x0,x1,y0,y1,"1");
              }
              else if(dx>0 && dy <0){
                  //6
                  float se = dy+dx*2;
                  float s =dx*2;
                  float dinit = dy+2*dx;
                  while(y0>y1){
                      if(dinit<0){
                          //s
                          y0=y0-0.01f;
                          dinit =dinit+s;
                      }else{
                          
                          y0=y0-0.01f;
                          x0=x0+0.01f;
                          dinit = dinit +se;
                      }
                  gl.glColor3d(0.5, 0, 1);
                  gl.glVertex2d(x0,y0);
                  }
                  pointsPrinter(x0,x1,y0,y1,"6");
              }
              else if(dx<0 && dy >0){
                  //2
                  float dinit = -dy - 2*dx;
                  float n = -dx *2;
                  float nw = -dy - dx*2;
                  while(y0<y1){
                      if(dinit <0){
                          y0=y0+0.01f;
                          dinit = dinit + n;
                      }else{
                          y0=y0+0.01f;
                          x0=x0-0.01f;
                          dinit = dinit + nw;
                      }
                  gl.glColor3d(0.9, 2, 1.4);
                  gl.glVertex2d(x0,y0);
                  }
                  pointsPrinter(x0,x1,y0,y1,"2");              }
              else if(dx<0 && dy <0){
                  //5
                  float dinit=-dy+2*dx;
                  float sw=-dy+dx*2;
                  float s=dx*2;
                  
                  while(y0>y1){
                  if(dinit<0){
                      x0=x0-0.01f;
                      y0=y0-0.01f;
                      dinit =dinit+sw;
                  }else{
                      y0=y0-0.01f;
                      dinit=dinit+s;
                  }
                  gl.glColor3d(1,1,1);
                  gl.glVertex2d(x0,y0);
                  }pointsPrinter(x0,x1,y0,y1,"5");
              }
          }else{
              //zone 0,3,4,7
              //dy>dx
              if(dx>0 && dy >0){
                  //0
                  float dinit=dy*2-dx;
                  float ne = dy*2-dx;
                  float e = dy*2;
                 
                  while(x0<x1){
                      if(dinit>0){
                     y0=y0+0.01f;
                     x0=x0+0.01f;
                     dinit = dinit+ne;
                 }else{
                     x0=x0+0.01f;
                     dinit = dinit +e;
                 }
                  gl.glColor3d(1, 1, 0.4);
                  gl.glVertex2d(x0,y0);
                  }
                  pointsPrinter(x0,x1,y0,y1,"0");
              }
             else if(dx>0 && dy <0){
                  //7
                  float dinit =2*dy +dx;
                  float se = 2*dy+dx;
                  float e =2*dy;
                  while(x0<x1){
                      if(dinit<0){
                          //se
                          x0=x0+0.01f;
                          y0=y0-0.01f;
                          dinit = dinit+se;
                      }else{
                          //e
                          x0=x0+0.01f;
                          dinit=dinit+e;
                      }
                  gl.glColor3d(0.6, 0.6, 0.6);
                  gl.glVertex2d(x0,y0);
                  }pointsPrinter(x0,x1,y0,y1,"7");
              }
             else if(dx<0 && dy >0){
                  //3
                  float dinit = -dy*2 -dx;
                  float nw = -dy*2 -dx;
                  float w = -dy *2;
                  
                  while(x0>x1){
                      if(dinit<0){
                          y0=y0+0.01f;
                          x0=x0-0.01f;
                          dinit = dinit + nw;
                      }else{
                          x0=x0-0.01f;
                          dinit =dinit + w;
                      }
                  gl.glColor3d(0.9, 0.9, 0.5);
                  gl.glVertex2d(x0,y0);
                  }pointsPrinter(x0,x1,y0,y1,"3");
              }
             else if(dx<0 && dy <0){
                  //4
                  float dinit = -dy*2+dx;
                  float w =-dy*2;
                  float sw =-dy*2+dx;
                  while(x0>x1){
                      if(dinit>0){
                          //sw
                          x0=x0-0.01f;
                          y0=y0-0.01f;
                          dinit = dinit + sw;
                      }else{
                          x0=x0-0.01f;
                          dinit=dinit+w;
                      }
                  
                  gl.glColor3d(1, .8, 0.4);
                  gl.glVertex2d(x0,y0);
                  }pointsPrinter(x0,x1,y0,y1,"4");
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
   public void pointsPrinter(float x0,float x1,float y0,float y1,String zone){
       System.out.print("for points: ");
                  System.out.print(x0);
                  System.out.print(", ");
                  System.out.print(x1);
                  System.out.print(", ");
                  System.out.print(y0);
                  System.out.print(", ");
                  System.out.print(y1);
                  System.out.print(" ->zone: "+zone);
                  System.out.println();
   }
}
}//end of classimport javax.media.opengl.GL2;