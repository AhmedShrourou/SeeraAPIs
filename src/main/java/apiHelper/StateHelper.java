package apiHelper;

import java.util.concurrent.ConcurrentHashMap;



public class StateHelper {

	private static volatile ConcurrentHashMap<Long, ConcurrentHashMap<String, Object>> CrossStoryState = new ConcurrentHashMap<Long, ConcurrentHashMap<String, Object>>();


	// * this method used to store values during the story inside
	public static void setStoryState(String key, Object value) {
		if (key != null && value != null) {
			synchronized (CrossStoryState) {
				ConcurrentHashMap<String, Object> chm = CrossStoryState.get(Thread.currentThread().getId());

				if (chm == null)

					chm = new ConcurrentHashMap<String, Object>();

				chm.put(key, value);
				CrossStoryState.put(Thread.currentThread().getId(), chm);

			}
		} else {


			System.out.print("Null Value not allowed");

		}
	}


	// * this method used to get saved data during the story,

	public static Object getStoryState(String key) {

		if (key != null) {
			synchronized (CrossStoryState) {
				return CrossStoryState.get(Thread.currentThread().getId()).get(key);

			}
		} else {
			return null;
		}
	}

	/**
	 * this method used to clear all data that saved in story.
	 * 
	 */
	public static void clearStoryState() {
		synchronized (CrossStoryState) {
			if (CrossStoryState==null)
			CrossStoryState.clear();

		}
	}

}