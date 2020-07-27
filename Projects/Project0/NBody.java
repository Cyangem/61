public class NBody {

    //return the radius of the universe reading from the file
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        in.readInt();
        double Radius = in.readDouble();

        return Radius;
    }

    //return an array of Bodies corresponding to the bodies in the file
    public static Body[] readBodies(String fileName) {
        In in = new In(fileName);
        int num = in.readInt();
        in.readDouble();
        Body[] Planets = new Body[num];

        int i = 0;
        while (i < num) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            Planets[i++] = new Body(xP, yP, xV, yV, m, img);
        }
        return Planets;
    }

    //draw the initial universe state
    public static void main(String[] args) {
        //get data
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String fileName = args[2];
        double uniRadius = NBody.readRadius(fileName);
        Body[] Planets = NBody.readBodies(fileName);

        //draw the background
        StdDraw.setScale(-uniRadius, uniRadius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "image/starfield.jpg");

        //draw planets
        for (Body planet : Planets) {
            planet.draw();
        }

        //Animation
        StdDraw.enableDoubleBuffering();

        //Set up a loop to loop until time variable reaches T
        for (double t = 0; t <= T; t += dt) {
            double[] xForces = new double[Planets.length];
            double[] yForces = new double[Planets.length];

            //calculate the net forces for every planet
            for (int i = 0; i < Planets.length; i++) {
                xForces[i] = Planets[i].calcNetForceExertedByX(Planets);
                yForces[i] = Planets[i].calcNetForceExertedByY(Planets);
            }

            //update positions and velocities of each planet
            for (int i = 0; i < Planets.length; i++) {
                Planets[i].update(dt, xForces[i], yForces[i]);
            }

            //draw the background
            StdDraw.picture(0, 0, "images/starfield.jpg");

            //draw all planets
            for (Body planet : Planets) {
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }

        StdOut.printf("%d\n", Planets.length);
        StdOut.printf("%.2e\n", uniRadius);
        for (int i = 0; i < Planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel,
                    Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);
        }
    }
    //use the following command lines to see the Animation! Happy Coding!
    //javac NBody.java
    //java NBody 157788000.0 25000.0 data/planets.txt
}