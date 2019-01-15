/**
 * NBody
 */
public class NBody {

    private static final String starfield = "images/starfield.jpg";

    public static double readRadius(String filePath) {

        In in = new In(filePath);
        int n = in.readInt();
        double radius = in.readDouble();
        return radius;

    }

    public static Planet[] readPlanets(String filePath) {
        In in = new In(filePath);
        int n = in.readInt();
        Planet[] arr = new Planet[n];
        double radius = in.readDouble();
        double xxPos, yyPos, xxVel, yyVel, mass;
        String fileName;
        int i = 0;
        while (i < n) {
            xxPos = in.readDouble();
            yyPos = in.readDouble();
            xxVel = in.readDouble();
            yyVel = in.readDouble();
            mass = in.readDouble();
            fileName = in.readString();

            arr[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, fileName);
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please supply a country as a command line argument.");
            System.out.println("For countries with spaces, use an underscore, e.g. South_Korea");
            /*
             * NOTE: Please don't use System.exit() in your code. It will break the
             * autograder.
             */
        }

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String fileName = args[2];

        double radius = readRadius(fileName);
        StdDraw.setScale(-radius, radius);

        /* Clears the drawing window. */
        StdDraw.clear();

        StdDraw.picture(0, 0, starfield);
        Planet[] arr = readPlanets(fileName);
        // for (Planet item : arr) {
        // item.draw();
        // }
        // StdDraw.show();
        // StdDraw.pause(2000);

        double time = 0;

        while (time < T) {
            double[] xForce = new double[arr.length];
            double[] yForce = new double[arr.length];
            int i = 0;
            for (Planet item : arr) {
                xForce[i] = item.calcNetForceExertedByX(arr);
                yForce[i] = item.calcNetForceExertedByY(arr);

                i++;
            }
            StdDraw.enableDoubleBuffering();
            StdDraw.picture(0, 0, starfield);
            i = 0;
            for (Planet item : arr) {
                item.update(dt, xForce[i], yForce[i]);
                item.draw();
                i++;
            }
            StdDraw.show();
            StdDraw.pause(10);

            time += dt;
        }
        StdOut.printf("%d\n", arr.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < arr.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", arr[i].xxPos, arr[i].yyPos, arr[i].xxVel,
                    arr[i].yyVel, arr[i].mass, arr[i].imgFileName);
        }
    }
}