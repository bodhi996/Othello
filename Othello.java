//To make the board game Othello using Swing
import javax.swing.*;
import java.awt.*;  
import java.util.*;
import java.io.*;
import java.text.*;
import java.awt.event.*; 
class Othello extends JFrame implements ActionListener
{
   JFrame f;
   JButton[][] b;
   int[][] be;
   JCheckBox cb1;
   JCheckBox cb2;
   static String move="";
   static int bm;
   static int c=0,m=0;
   Othello()
   {
    f=new JFrame("Othello");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(new GridLayout(3,3));  
    f.setSize(2000,2000);
    cb1=new JCheckBox("Black");
    cb1.setBounds(100,100,100,50);
    f.add(cb1);
    cb1.addItemListener(new ItemListener() {    
    public void itemStateChanged(ItemEvent e)
    {                 
      move="Black";
      bm=1;
    }    
    });
    cb2=new JCheckBox("White");
    cb2.setBounds(300,100,100,50);
    f.add(cb2);
    cb2.addItemListener(new ItemListener() {    
    public void itemStateChanged(ItemEvent e)
    {                 
       move="White";
       bm=0;
    }    
    });
    be=new int[8][8];
    b=new JButton[8][8];
    int i,j,c=200,r=175;
    for (i=0;i<8;i++)
    {
        c=200;
        for(j=0;j<8;j++)
        {
            be[i][j]=9;
            b[i][j]=new JButton();
            b[i][j].setBounds(c,r,100,100);
            b[i][j].addActionListener(this);
            c+=100;
            b[i][j].setBackground(Color.GREEN);
            f.add(b[i][j]);
        }
        r+=100;
    }
    be[3][3]=0;
    be[3][4]=1;
    be[4][3]=1;
    be[4][4]=0;
    b[3][3].setBackground(Color.WHITE);
    b[3][4].setBackground(Color.BLACK);
    b[4][3].setBackground(Color.BLACK);
    b[4][4].setBackground(Color.WHITE);
    f.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));
    f.setLayout(null);    
    f.setVisible(true);    
 }
 
 public void actionPerformed(ActionEvent e)
  { 
     int i,j;
     for(i=0;i<8;i++)
     {
        for(j=0;j<8;j++)
        {
           if(e.getSource()==b[i][j])
           {
               c++;
               if(c%2==1)
               bm=1;
               else
               bm=0;
               b[i][j].setText(move);
               be[i][j]=bm;
               checkdiagonal1(i,j);
               checkdiagonal2(i,j);
               checkvertical(i,j);
               checkhorizontal(i,j);
            }
        }
     }
     for(i=0;i<8;i++)
     {
         for(j=0;j<8;j++)
         {
             if(be[i][j]==1)
             {
               b[i][j].setBackground(Color.BLACK);
            }
             if(be[i][j]==0)
             b[i][j].setBackground(Color.WHITE);
         }
     }
     String str=""+m;
     b[0][0].setText(str);
  }
 public void checkdiagonal1(int a,int b)
   {
    int i=a+1,j=b+1,k,l;
    while(i<8&&j<8)
    {
           if(be[i][j]!=0&&be[i][j]!=1)
           break;
           if(be[i][j]==bm)
           {
               k=a;l=b;
               while(k<=i&&l<=j)
               {
                   be[k][l]=bm;
                   k++;
                   l++;
                   m++;
               }
           }
           i++;j++;
    }
    i=a-1;j=b-1;
    while(i>=0&&j>=0)
    {
           if(be[i][j]!=0&&be[i][j]!=1)
           break;
           if(be[i][j]==bm)
           {
               k=a;l=b;
               while(k>=i&&l>=j)
               {
                   be[k][l]=bm;
                   k--;
                   l--;
                   m++;
               }
           }
           i--;j--;
    }
   }
   public void checkdiagonal2(int a,int b)
   {
    int i=a+1,j=b-1,k,l;
    while(i<8&&j>=0)
    {
           if(be[i][j]!=0&&be[i][j]!=1)
           break;
           if(be[i][j]==bm)
           {
               k=a;l=b;
               while(k<=i&&l>=j)
               {
                   be[k][l]=bm;
                   k++;
                   l--;
                   m++;
               }
           }
           i++;j--;
    }
    i=a-1;j=b+1;
    while(i>=0&&j<8)
    {
           if(be[i][j]!=0&&be[i][j]!=1)
           break;
           if(be[i][j]==bm)
           {
               k=a;l=b;
               while(k>=i&&l<=j)
               {
                   be[k][l]=bm;
                   k--;
                   l++;
                   m++;
               }
           }
           i--;j++;
    }
   }
   public void checkhorizontal(int a, int b)
   {
      int i=a,j=b,k;
      for(j=b+1;j<8;j++)
      {
          if(be[i][j]!=0&&be[i][j]!=1)
          break;
          if(be[i][j]==bm)
          {
              for(k=b;k<=j;k++)
                {
                    be[i][k]=bm;
                    m++;
                }
          }
      } 
      for(j=b-1;j>=0;j--)
      {
          if(be[i][j]!=0&&be[i][j]!=1)
          break;
          if(be[i][j]==bm)
          {
              for(k=b;k>=j;k--)
              {
                    be[i][k]=bm;
                    m++;
              }
          }
      } 
   }
   public void checkvertical (int a, int b)
   {
      int i=a,j=b,k;
      for(i=a+1;i<8;i++)
      {
          if(be[i][j]!=0&&be[i][j]!=1)
          break;
          if(be[i][j]==bm)
          {
              for(k=a;k<=i;k++)
                {
                    be[k][j]=bm;
                    m++;
                }
          }
      } 
      for(i=a-1;i>=0;i--)
      {
          if(be[i][j]!=0&&be[i][j]!=1)
          break;
          if(be[i][j]==bm)
          {
              for(k=a;k>=i;k--)
              {
                    be[k][j]=bm;
                    m++;
              }
          }
      } 
   }

   public static void main()
   {
      Othello ob=new Othello();
   }
 }
