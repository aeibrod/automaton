package automaton.io;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Resource {

	/**
	 * <p>
	 * Returns an input stream of the specified resource.
	 * </p>
	 * 
	 * <p>
	 * Example:
	 * </p>
	 * 
	 * <blockquote>
	 * <code>
	 * Resource.getRes("res/presets/spaceships/glider.life");
	 * </code>
	 * </blockquote>
	 * 
	 * @param path The path of the resource.
	 * 
	 * @return An input stream of the specified resource.
	 * 
	 * @see #getImage(String)
	 */
	public static InputStream getRes(String path) {

		if (path.startsWith("/")) {
			path = path.substring(1);
		}

		return ClassLoader.getSystemClassLoader().getResourceAsStream(path);

	}

	/**
	 * <p>
	 * Returns an image of the specified resource, or null.
	 * The path <b>must</b> start with a slash.
	 * </p>
	 * 
	 * <p>
	 * Example:
	 * </p>
	 * 
	 * <blockquote>
	 * <code>
	 * Resource.getImage("res/texture/icon.png");
	 * </code>
	 * </blockquote>
	 * 
	 * @param path The path of the resource.
	 * 
	 * @return An image of the specified resource, or null.
	 * 
	 * @see #getRes(String)
	 */
	public static Image getImage(String path) {

		try {

			return ImageIO.read(new BufferedInputStream(getRes(path)));

		} catch (Exception e) {
			Console.err(e, Resource.class);
		}

		return null;
	}

}
