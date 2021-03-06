package ecs;

import com.jogamp.opengl.GL2;
import ecs.Component;

import java.util.LinkedList;

/**
 * Created by alexa on 4/30/2016.
 */
@SuppressWarnings("Convert2streamapi")
public abstract class Entity {

    public LinkedList<Component> components;
    public float[] pos;

    GL2 gl;

    public Entity(GL2 gl) {
        components = new LinkedList<>();
        this.pos = new float[]{0.0f, 0.0f, 0.0f};
        this.gl = gl;
    }

    public Entity(GL2 gl, float[] pos) {
        components = new LinkedList<>();
        this.pos = pos;
        this.gl = gl;
    }

    public void update() {
        for(Component c : components) {
            c.update();
        }
    }

    public void render() {
        for(Component c : components) {
            c.render();
        }
    }

    public void addComponent(Component c) {
        components.add(c);
        c.parent = this;
    }

    public void removeComponent(Component c) {
        components.remove(c);
        c.parent = null;
    }

    public abstract double[] getBoundingBox();
}
