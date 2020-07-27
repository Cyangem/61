public class Body {

    //its current x position
    public double xxPos;

    //its current y position
    public double yyPos;

    //its current velocity in the x direction
    public double xxVel;

    //its current velocity in the y direction
    public double yyVel;

    public double mass;

    //The name of the file that corresponds to the image that depicts the body
    public String imgFileName;

    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    //calculate the distance between two bodies
    public double calcDistance(Body b) {
        double dx = this.xxPos - b.xxPos; //b.xxPos - xxPos
        double dy = this.yyPos - b.yyPos;
        double r = Math.hypot(dx, dy); //Math.sqrt(dx*dx + dy*dy)
        return r;
    }

    //private static final double G = 6.67E-11;

    //calculate the force exerted on this body by the given body
    public double calcForceExertedBy(Body b) {
        double G = 6.67e-11;
        double F = (G * this.mass * b.mass) / Math.pow(this.calcDistance(b), 2);
        return F;
    }

    //calculate the force in x direction and y direction
    public double calcForceExertedByX(Body b) {
        double Fx = this.calcForceExertedBy(b) * (b.xxPos - this.xxPos) / this.calcDistance(b);
        return Fx;
    }
    public double calcForceExertedByY(Body b) {
        double Fy = this.calcForceExertedBy(b) * (b.xxPos - this.xxPos) / this.calcDistance(b);
        return Fy;
    }

    //calculate the net force in x direction and y direction
    public double calcNetForceExertedByX(Body[] bs) {
        double FxNet = 0;
        for (Body b: bs) {
            if (!this.equals(b)) {
                FxNet += this.calcForceExertedByX(b);
            }
        }
        return FxNet;
    }

    public double calcNetForceExertedByY(Body[] bs) {
        double FyNet = 0;
        for (Body b: bs) {
            if (!this.equals(b)) {
                FyNet += this.calcForceExertedByY(b);
            }
        }
        return FyNet;
    }

    //update the velocity and position of the Body under the effect of force
    public void update(double dt, double fX, double fY) {
        double ax = fX / this.mass;
        double ay = fY / this.mass;
        this.xxVel += ax * dt;
        this.yyVel += ay * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    //draw the picture of the Body according to its position
    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}