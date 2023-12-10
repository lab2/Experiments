using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    public partial class Mandelbrot : Form
    {
    private static double XMIN = -2;
    private static double XMAX = 2;
    private static double YMIN = -2;
    private static double YMAX = 2;
    private static int MAX_ITERATIONS = 32;
    public int color = 0, iter;
    public Color c;
        public Mandelbrot()
        {
            InitializeComponent();
          
            Paint += new PaintEventHandler(Form1_Paint);
        }
        
        private void Form1_Load(object sender, EventArgs e)
        {
           
        }

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = drawPanel.CreateGraphics();
            g.SmoothingMode = System.Drawing.Drawing2D.SmoothingMode.AntiAlias;

            for (int i = 0; i < 430; i++)
                for (int j = 0; j < 400; j++)
                {
                    double a = XMIN + i * (XMAX - XMIN) / 430;
                    double b = YMIN + j * (YMAX - YMIN) / 400;
                    if (escapesToInfinity(a, b))
                    {
                        SolidBrush my = new SolidBrush(c);
                        g.FillEllipse(my, i, j, 2, 2);
                    }
                }            
        }

        private bool escapesToInfinity(double a, double b)
        {
            double x = 0.0;
            double y = 0.0;
            int iterations = 0;
            do
            {
                double xnew = x * x - y * y + a;
                double ynew = 2 * x * y + b;
                x = xnew;
                y = ynew;
                iterations++;
                if (iterations == MAX_ITERATIONS)
                    return false;
            } while (x <= 2 && y <= 2);

            if (iterations <= 8)
                c = Color.FromArgb(iterations * 8, 0, 0);
            if (iterations >= 9)
                c = Color.FromArgb(iterations * 8, 0, 0);

            
            return true;
        }


        private void drawPanel_Paint(object sender, PaintEventArgs e)
        {
        }

    }
}
