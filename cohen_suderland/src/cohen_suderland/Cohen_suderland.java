/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cohen_suderland;

import java.util.Scanner;
import javax.media.opengl.GL;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2ES1;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.swing.JFrame;
import java.util.Random;
/**
 *
 * @author erfan
 */
public class Cohen_suderland {
    
    
static int max_random = 300;
static int min_random = -300;

static float final_points [][];  //5th pos: 0-accepted,1-rejected,2-partially accepted


static int  numberOfLines = 0;
static int numberOfLines2 =0;   

static int xmax = 200;
static int xmin = -200;
static int ymax = 200;
static int ymin = -200;
static GLProfile profile = GLProfile.get(GLProfile.GL2);
        static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODOcode application logic 
        
        Scanner nemesis = new Scanner(System.in);
        System.out.println("Please enter how many randomly generated lines you want:");
        numberOfLines = nemesis.nextInt();
        float points [][] = new float [numberOfLines][4];//x0,y0,x1,y1
        
        final_points = new float [numberOfLines][5];//x0,y0,x1,y1,a/r/pa

        Random r = new Random();
        
        for(int i =0; i <numberOfLines; i++){
            
            //points[i][j] = ((r.nextFloat()*2)-1)*100;
            points[i][0] = r.nextInt(max_random - min_random + 1) + min_random;
            points[i][1] = r.nextInt(max_random - min_random + 1) + min_random;
            
            float temp = r.nextInt(max_random - min_random + 1) + min_random;
            while(temp <= points[i][0]){
                temp = r.nextInt(max_random - min_random + 1) + min_random;
            }
            points[i][2] = temp;
            
            float temp2 = r.nextInt(max_random - min_random + 1) + min_random;
            while(temp2 <= points[i][1]){
                temp2 = r.nextInt(max_random - min_random + 1) + min_random;
            }
            points[i][3] = temp2;
            
            
         }
        
        System.out.println("x0, y0, x1, y1 in (every line)");
        for(int i =0; i <numberOfLines; i++){
            for(int j =0; j <4;j++){
            System.out.print(points[i][j]);
            System.out.print("  ");
            }
            System.out.println();
         }
        for(int i=0; i< numberOfLines;i++){
            cohen_brother(points[i][0],points[i][1], points[i][2],points[i][3]);
        }
        System.out.println("after clipping");
        for(int i=0; i< numberOfLines;i++){
            for ( int j=0;j<4;j++){
                System.out.print(final_points[i][j]);
                System.out.print("  ");
            }
            System.out.println("  ");
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
    static void cohen_brother(float x0, float y0, float x1, float y1){
        int top =8; //1000
        int bottom = 4; //0100
        int left = 1; //0001
        int right = 2; //0010
        int code, code0, code1;
        float x=0;
        float y=0;
        while(true){
            
            code0 = makeCode(x0,y0);
            code1 = makeCode(x1,y1);
            if( (code0 | code1) == 0 ){
                
                //accepted
                final_points[numberOfLines2][0] = x0;
                final_points[numberOfLines2][1] = y0;
                final_points[numberOfLines2][2] = x1;
                final_points[numberOfLines2][3] = y1;
                final_points[numberOfLines2][4] = 0;
                
                numberOfLines2++;
              
                break;
            }else if( (code0 & code1) >=1 ){
                //rejected manushjon
                
                final_points[numberOfLines2][0] = x0;
                final_points[numberOfLines2][1] = y0;
                final_points[numberOfLines2][2] = x1;
                final_points[numberOfLines2][3] = y1;
                final_points[numberOfLines2][4] = 1;
                numberOfLines2++;
                
                
                
                break;
            }else{
                //partially accepted
                if (code0 >=1){
                    code = code0;
                }else {
                    code = code1;
                }
                if ((code & top) != 0){
                    //point is above ymax
                    x = x0 + (((ymax-y0)/(y1-y0))*(x1-x0));
                    y=ymax;
                } else if ((code & bottom) != 0){
                    //point is above ymin
                    x = x0 + (((ymin-y0)/(y1-y0))*(x1-x0));
                    y=ymin;
                }else if ((code & right) != 0){
                    //point is right to xmax
                    y = y0 + (((xmax-x0)/(x1-x0))*(y1-y0));
                    x=xmax;
                }else if ((code & left) != 0){
                    //point is left to xmin
                    y = y0 + (((xmin-x0)/(x1-x0))*(y1-y0));
                    x=xmin;
                }
                if( code == code0){
                    x0 = x;
                    y0 = y;
                }else {
                    x1 = x;
                    y1 = y;
                }
                
                
                //for draw line
                
                final_points[numberOfLines2][0] = x0;
                final_points[numberOfLines2][1] = y0;
                final_points[numberOfLines2][2] = x1;
                final_points[numberOfLines2][3] = y1;
                final_points[numberOfLines2][4] = 2;
                numberOfLines2++;
                
                break;
            }
           
        }
    }
    static int makeCode(float x, float y){
        int outCode = 0;
        if(x <xmin){
            outCode +=1;
        }else if ( x>xmax ){
            outCode += 2;
        }
        if( y<ymin ){
            outCode += 4;
        }else if( y>ymax ){
            outCode += 8;
        }
        return outCode;
    }
  
static class xx  implements GLEventListener{
    
    
      public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
       	  gl.glBegin (GL2.GL_POINTS);//static field
         for(int i = xmin; i < xmax; i++){
                  gl.glColor3d(1, 1, 1);
                  gl.glVertex2d(ymin,i);
                  gl.glVertex2d(ymax,i);
          }
         
         for(int i = ymin; i < ymax; i++){
                  gl.glColor3d(1, 1, 1);
                  gl.glVertex2d(i,xmin);
                  gl.glVertex2d(i,xmax);
          }
         for(int oo =0;oo<numberOfLines2;oo++){
         
            float x0 = final_points[oo][0];
            float y0 = final_points[oo][1];
            float x1 = final_points[oo][2];
            float y1 = final_points[oo][3];
            
            float color =  final_points[oo][4];
            float dx= x1-x0;
            float dy=y1-y0;
            
            float r = 0;
            float g = 0;
            float b = 0;
            if(color == 0){
                g=1;
            }else if(color ==1){
                r = 1;
            }else if(color ==2 ){
                b = 1;
            }
          if(Math.abs(dy) >= Math.abs(dx)){
              //zone 1,2,5,6
              //dy>dx
              //y loop controller
              if(dx>=0 && dy >=0){
                  //1
                  float dinit = dy-2*dx;
                  float ne = dy-2*dx;
                  float n = -2*dx;
                  while(y0<y1){
                      if(dinit>=0){
                          y0=y0+0.01f;
                          dinit = dinit + n;
                      }else{
                          y0=y0+0.01f;
                          x0=x0+0.01f;
                          dinit = dinit + ne;
                      }
                  
                  
                  gl.glColor3d(r,g,b);
                  gl.glVertex2d(x0,y0);
                  }
                  
                  //pointsPrinter(x0,x1,y0,y1,"1");
              }
              else if(dx>=0 && dy <0){
                  //6
                  float se = dy+dx*2;
                  float s =dx*2;
                  float dinit = dy+2*dx;
                  while(y0>=y1){
                      if(dinit<0){
                          //s
                          y0=y0-0.01f;
                          dinit =dinit+s;
                      }else{
                          
                          y0=y0-0.01f;
                          x0=x0+0.01f;
                          dinit = dinit +se;
                      }
                  gl.glColor3d(r,g,b);
                  gl.glVertex2d(x0,y0);
                  }
                  //pointsPrinter(x0,x1,y0,y1,"6");
              }
              else if(dx<0 && dy >=0){
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
                  gl.glColor3d(r,g,b);
                  gl.glVertex2d(x0,y0);
                  }
                  //pointsPrinter(x0,x1,y0,y1,"2"); 
              }
              else if(dx<0 && dy <0){
                  //5
                  float dinit=-dy+2*dx;
                  float sw=-dy+dx*2;
                  float s=dx*2;
                  
                  while(y0>=y1){
                  if(dinit<0){
                      x0=x0-0.01f;
                      y0=y0-0.01f;
                      dinit =dinit+sw;
                  }else{
                      y0=y0-0.01f;
                      dinit=dinit+s;
                  }
                  gl.glColor3d(r,g,b);
                  gl.glVertex2d(x0,y0);
                  }//pointsPrinter(x0,x1,y0,y1,"5");
              }
          }else{
              //zone 0,3,4,7
              //dy>dx
              if(dx>=0 && dy >=0){
                  //0
                  float dinit=dy*2-dx;
                  float ne = dy*2-dx;
                  float e = dy*2;
                 
                  while(x0<x1){
                      if(dinit>=0){
                     y0=y0+0.01f;
                     x0=x0+0.01f;
                     dinit = dinit+ne;
                 }else{
                     x0=x0+0.01f;
                     dinit = dinit +e;
                 }
                  gl.glColor3d(r,g,b);
                  gl.glVertex2d(x0,y0);
                  }
                  //pointsPrinter(x0,x1,y0,y1,"0");
              }
             else if(dx>=0 && dy <0){
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
                  gl.glColor3d(r,g,b);
                  gl.glVertex2d(x0,y0);
                  }//pointsPrinter(x0,x1,y0,y1,"7");
              }
             else if(dx<0 && dy >=0){
                  //3
                  float dinit = -dy*2 -dx;
                  float nw = -dy*2 -dx;
                  float w = -dy *2;
                  
                  while(x0>=x1){
                      if(dinit<0){
                          y0=y0+0.01f;
                          x0=x0-0.01f;
                          dinit = dinit + nw;
                      }else{
                          x0=x0-0.01f;
                          dinit =dinit + w;
                      }
                  gl.glColor3d(r,g,b);
                  gl.glVertex2d(x0,y0);
                  }//pointsPrinter(x0,x1,y0,y1,"3");
              }
             else if(dx<0 && dy <0){
                  //4
                  float dinit = -dy*2+dx;
                  float w =-dy*2;
                  float sw =-dy*2+dx;
                  while(x0>=x1){
                      if(dinit>=0){
                          //sw
                          x0=x0-0.01f;
                          y0=y0-0.01f;
                          dinit = dinit + sw;
                      }else{
                          x0=x0-0.01f;
                          dinit=dinit+w;
                      }
                  
                  gl.glColor3d(r,g,b);
                  gl.glVertex2d(x0,y0);
                  }//pointsPrinter(x0,x1,y0,y1,"4");
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
}