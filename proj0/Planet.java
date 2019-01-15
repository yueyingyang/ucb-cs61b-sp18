/**
 * Planet
 */
public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;

    public double mass;
    public String imgFileName;

    private static final double G = 6.67E-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {

        double distance;
        double dx = xxPos - p.xxPos;
        double dy = yyPos - p.yyPos;
        distance = Math.sqrt(dx * dx + dy * dy);
        return distance;

    }

    public double calcForceExertedBy(Planet p) {

        double force;
        force = G * mass * p.mass / (calcDistance(p) * calcDistance(p));
        return force;

    }

    public double calcForceExertedByX(Planet p) {
        double Fx;
        Fx = calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
        return Fx;
    }

    public double calcForceExertedByY(Planet p) {
        double Fy;
        Fy = calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
        return Fy;
    }

    public double calcNetForceExertedByX(Planet[] all) {

        double netForce = 0;
        for (Planet ele : all) {
            if (!this.equals(ele)) {
                netForce += this.calcForceExertedByX(ele);
            }
        }
        return netForce;

    }

    public double calcNetForceExertedByY(Planet[] all) {
        double netForce = 0;
        for (Planet ele : all) {
            if (!this.equals(ele)) {
                netForce += this.calcForceExertedByY(ele);
            }
        }
        return netForce;
    }

    public void update(double dt, double fX, double fY) {
        double ax, ay;
        ax = fX / mass;
        ay = fY / mass;
        xxVel += dt * ax;
        yyVel += dt * ay;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }

}