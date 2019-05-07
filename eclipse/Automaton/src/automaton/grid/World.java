package automaton.grid;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import automaton.maths.Coordinates;
import automaton.maths.Point;
import automaton.render.RenderingContext;

/**
 * <p>
 * The world class represent the entire grid
 * of the grid system.
 * </p>
 * 
 * <p>
 * In the grid system, a world contains chunks, a chunk
 * contains cells.
 * </p>
 * 
 * @see Chunk
 * @see Cell
 */
public class World {

	/**
	 * The map where all chunks are stored with their coordinates.
	 */
	protected Map<Point, Chunk> chunks = new ConcurrentHashMap<>();


	/**
	 * Updates all chunks.
	 */
	public void update() {

		Iterator<Entry<Point, Chunk>> iterator = getChunks();
		Chunk chunk;

		while (iterator.hasNext()) {

			iterator.next().getValue().updateNextState();

		}

		iterator = getChunks();

		while (iterator.hasNext()) {

			chunk = iterator.next().getValue();

			chunk.updateState();

			if (chunk.isEmpty()) {
				remove(chunk);
				iterator.remove();
			}

		}

	}

	/**
	 * Renders all chunks on a canvas through a rendering context.
	 * 
	 * @param context The rendering context.
	 */
	public void render(RenderingContext context) {

		Iterator<Entry<Point, Chunk>> iterator = getChunks();

		while (iterator.hasNext()) {

			iterator.next().getValue().render(context);

		}

	}


	/**
	 * Creates a new living cell at the specified location.
	 * If a chunk does not exist at the location, it will
	 * be automatically added.
	 * 
	 * @param coordinates The cell coordinates.
	 * 
	 * @see #toogle(Coordinates)
	 */
	public void active(Coordinates coordinates) {
		getChunkAt(coordinates, true).active(coordinates, true);
	}

	/**
	 * <p>
	 * Creates a new living cell at the specified location
	 * if there is not already a living cell. If a chunk
	 * does not exist at the location, it will be
	 * automatically added.
	 * </p>
	 * 
	 * <p>
	 * Removes the cell at the specified location if there
	 * is a living cell.
	 * </p>
	 * 
	 * @param coordinates The cell coordinates.
	 * 
	 * @see #active(Coordinates)
	 */
	public void toogle(Coordinates coordinates) {

		if (!hasChunkAt(coordinates)) {
			active(coordinates);
			return;
		}

		Chunk chunk = getChunkAt(coordinates);

		if (!chunk.hasCellAt(coordinates)) {
			active(coordinates);
			return;
		}

		Cell cell = chunk.getCellAt(coordinates);

		if (!cell.isAlive()) {

			/* Need to remove the current cell whatever his state. */
			chunk.remove(cell);
			active(coordinates);

			return;

		}

		chunk.remove(cell);

	}


	/**
	 * Indicates if a chunk is present at the specified location.
	 * 
	 * @param coordinates The chunk coordinates.
	 * 
	 * @return true if there is a chunk; false otherwise.
	 */
	public boolean hasChunkAt(Coordinates coordinates) {
		return chunks.containsKey(coordinates.toChunkPoint());
	}


	/**
	 * Returns the chunk present at the specified location or null
	 * if it does not exist.
	 * 
	 * @param coordinates The chunk coordinates.
	 * 
	 * @return A chunk or null.
	 * 
	 * @see #getChunkAt(Coordinates, boolean)
	 * @see Chunk
	 */
	public Chunk getChunkAt(Coordinates coordinates) {
		return getChunkAt(coordinates, false);
	}

	/**
	 * <p>
	 * Returns the chunk present at the specified location.
	 * <p>
	 * 
	 * <p>
	 * This method can force the creation of the chunk if it
	 * does not exist.
	 * </p>
	 * 
	 * @param coordinates The chunk coordinates.
	 * @param force Precise if the chunk is forced to be created.
	 * 
	 * @return A chunk or null.
	 * 
	 * @see #getChunkAt(Coordinates)
	 * @see Chunk
	 */
	public Chunk getChunkAt(Coordinates coordinates, boolean force) {

		if (!hasChunkAt(coordinates) && !force) {
			return null;
		}

		if (!hasChunkAt(coordinates)) {
			register(new Chunk(this, coordinates.clone().normalizeForChunk()));
		}

		return chunks.get(coordinates.toChunkPoint());
	}


	/**
	 * Registers a new chunk on the map.
	 * 
	 * @param chunk The chunk to register.
	 */
	public void register(Chunk chunk) {
		chunks.putIfAbsent(chunk.getCoordinates().toChunkPoint(), chunk);
	}

	/**
	 * Removes an existing chunk on the map.
	 * 
	 * @param chunk The chunk to remove.
	 */
	public void remove(Chunk chunk) {
		chunks.remove(chunk.getCoordinates().toChunkPoint());
	}


	/**
	 * Clears the entire world by remove all chunks.
	 */
	public void clear() {
		chunks.clear();
	}

	/**
	 * Indicates if the world contains chunks or not.
	 * 
	 * @return true if the chunk is empty; false otherwise.
	 */
	public boolean isEmpty() {
		return chunks.isEmpty();
	}


	/**
	 * Returns an iterator of all chunks coupled with their
	 * chunk format coordinates.
	 * 
	 * @return An iterator of all chunks.
	 * 
	 * @see Chunk
	 * @see Point
	 */
	public Iterator<Entry<Point, Chunk>> getChunks() {
		return chunks.entrySet().iterator();
	}

}
