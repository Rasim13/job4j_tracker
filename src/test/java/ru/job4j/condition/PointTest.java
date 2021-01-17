package ru.job4j.condition;

import junit.framework.TestCase;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class PointTest extends TestCase {

    public void testDistance() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        double dist = a.distance(b);
        Assert.assertEquals(4,dist,0.01);
    }
}