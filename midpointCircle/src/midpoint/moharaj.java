/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midpoint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.media.opengl.GL;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2ES1;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import static javax.media.opengl.GLProfile.GL2ES1;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;


public class moharaj{
	static float[][] points = new float[100][3];
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

			br = new BufferedReader(new FileReader("C:\\Users\\erfan\\Desktop\\cira.txt"));
                        
			while ((sCurrentLine = br.readLine()) != null) {
                             String [] temp_points= sCurrentLine.split(",");
                            
                          for(int i =0;i<3;i++){
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
	      
	      final JFrame frame = new JFrame ("Lab circle ");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	   }
 
   static class xx  implements GLEventListener{
    
    
      public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
       	  gl.glBegin (GL2.GL_POINTS);//static field
          
        
          for(float i = -1000f;i<1000f;i=i+0.001f){
                  gl.glColor3d(1, .1, 1);
                  gl.glVertex2d(0,i);
                  gl.glVertex2d(i,0);
          }
          for(int ix=0;ix<counter;ix++){
            float x0 = points[ix][0];
            float y0 = points[ix][1];
            float radius = points[ix][2];
            
            float x = radius;
            float y =0;
            float decisionOver2 = 1-x;
            while( y <= x){
                gl.glColor3d(1, 1, 1);
                gl.glVertex2d(x+x0,y+y0); //ocat 1 
                gl.glVertex2d(y+x0,x+y0); //ocat 1 
                gl.glVertex2d(-x+x0,y+y0); //ocat 1 
                gl.glVertex2d(-y+x0,x+y0); //ocat 1 
                gl.glVertex2d(x+x0,-y+y0); //ocat 1 
                gl.glVertex2d(y+x0,-x+y0); //ocat 1 
                gl.glVertex2d(-x+x0,-y+y0); //ocat 1 
                gl.glVertex2d(-y+x0,-x+y0); //ocat 1 
                y=y+0.001f;
                if(decisionOver2 <=0){
                    decisionOver2 = decisionOver2 + ( 2 * y + 1);
                }else{
                    x=x-0.001f;
                    decisionOver2 = decisionOver2 + ( 2 * (y-x) + 1 );
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
      GL baa = arg0.getGL();
      ((GL2ES1)baa).glOrtho(-800,arg3, -600 ,arg4, -1.0, 1.0);
   }
 
}
}//end of classimport javax.media.opengl.GL2;