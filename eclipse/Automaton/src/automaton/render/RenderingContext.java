package automaton.render;

import java.awt.Graphics;

import automaton.config.Conf;
import automaton.grid.Cell;
import automaton.grid.Chunk;
import automaton.maths.Coordinates;

/**
 * The rendering context go over the graphics
 * to allow rendering on a canvas.
 */
public class RenderingContext {

	/**
	 * Graphics that renders on the canvas.
	 */
	protected Graphics graphics;

	/**
	 * Current zoom level.
	 */
	protected int zoom = Conf.CANVAS_DEFAULT_ZOOM;


	/**
	 * Defines the graphics that renders on the canvas.
	 */
	public void setGraphics(Graphics graphics) {
		this.graphics = graphics;
	}


	/**
	 * <p>
	 * Draws a filled cell.
	 * <p>
	 * 
	 * <p>
	 * The color of the cell respects the following rules:
	 * </p>
	 * 
	 * <ul>
	 * <li>it the color is not activated, its color is black.</li>
	 * <li>if the color is activated and the cell is living in the next state, its color is blue.</li>
	 * <li>if the color is activated and the cell is dying in the next state, its color is red.</li>
	 * </ul>
	 */
	public void drawCell(Cell cell) {

		if (graphics == null) {
			return;
		}

		Coordinates coordinates = cell.getCoordinates();

		if (Conf.CANVAS_ACTIVE_COLORED_CELLS) {

			if (cell.isIsolated() || cell.isOverpopulated()) {
				graphics.setColor(Conf.CANVAS_DYING_CELL_COLOR);
			}

			else {
				graphics.setColor(Conf.CANVAS_LIVING_CELL_COLOR);
			}

		} else {

			graphics.setColor(Conf.CANVAS_DEFAULT_CELL_COLOR);

		}

		/*
		 * L'axe des ordonnées est renversé car la grille est renversée
		 * par rapport à la position des pixels sur l'écran.
		 */
		graphics.fillRect(
			coordinates.getAbsoluteX() * zoom,
			-coordinates.getAbsoluteY() * zoom - zoom,
			zoom,
			zoom
		);

	}

	/**
	 * Draws the border of a chunk.
	 */
	public void drawChunkBorder(Chunk chunk) {

		if (graphics == null) {
			return;
		}

		Coordinates coordinates = chunk.getCoordinates();

		graphics.setColor(Conf.CANVAS_CHUNK_BORDERS_COLOR);

		/*
		 * L'axe des ordonnées est renversé car la grille est renversée
		 * par rapport à la position des pixels sur l'écran.
		 */
		graphics.drawRect(
			coordinates.getAbsoluteX() * zoom,
			-coordinates.getAbsoluteY() * zoom - (Chunk.SIZE * zoom),
			Chunk.SIZE * zoom,
			Chunk.SIZE * zoom
		);

	}


	/**
	 * Zoom on the canvas
	 * 
	 * @see #unzoom()
	 * @see #getZoomLevel()
	 */
	public void zoom() {

		if (zoom == Conf.CANVAS_MAXIMUM_ZOOM) {
			return;
		}

		zoom += 1;
	}

	/**
	 * Unzoom on the canvas
	 * 
	 * @see #zoom()
	 * @see #getZoomLevel()
	 */
	public void unzoom() {

		if (zoom == Conf.CANVAS_MINIMUM_ZOOM) {
			return;
		}

		zoom -= 1;
	}


	/**
	 * Returns the current zoom level.
	 * 
	 * @return The current zoom level.
	 * 
	 * @see #zoom()
	 * @see #unzoom()
	 */
	public int getZoomLevel() {
		return zoom;
	}

}
