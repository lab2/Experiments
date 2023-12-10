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
    public partial class Julia : Form
    {
        private static double XMIN = -2;
        private static double XMAX = 2;
        private static double YMIN = -2;
        private static double YMAX = 2;
        private static int MAX_ITERATIONS = 32;
        public double c1, c2;
        public Color c;
        public Julia()
        {
            InitializeComponent();
            
            
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void Form2_Paint(object sender, PaintEventArgs e)
        {
            
        }

        private bool escapesToInfinity(double a, double b)
        {
            double x = a;
            double y = b;
            int iterations = 0;
            do
            {
                double xnew = x * x - y * y + c1;
                double ynew = 2 * x * y + c2;
                x = xnew;
                y = ynew;
                iterations++;
                if (iterations == MAX_ITERATIONS)
                    return false;
            } while (x <= 2 && y <= 2);

            if (iterations <= 8)
                c = Color.FromArgb(0, iterations * 8, 0);
            if (iterations >= 9)
                c = Color.FromArgb(0, iterations * 8, 0);


            return true;
        }


        private void drawPanel_Paint(object sender, PaintEventArgs e)
        {
           
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                if (c1Input.Text != "" && c2Input.Text != "")
                {
                    drawPanel.Refresh();
                    c1 = Convert.ToDouble(c1Input.Text);
                    c2 = Convert.ToDouble(c2Input.Text);
                    Graphics g = drawPanel.CreateGraphics();
                    g.SmoothingMode = System.Drawing.Drawing2D.SmoothingMode.AntiAlias;

                    for (int i = 0; i < 380; i++)
                        for (int j = 0; j < 410; j++)
                        {
                            double a = XMIN + i * (XMAX - XMIN) / 380;
                            double b = YMIN + j * (YMAX - YMIN) / 410;
                            if (escapesToInfinity(a, b))
                            {
                                SolidBrush my = new SolidBrush(c);
                                g.FillEllipse(my, i, j, 2, 2);
                            }
                        }
                }
            }
            catch (Exception ex) { MessageBox.Show("Please input a valid value", "Invalid values"); }
        }

    }
}

