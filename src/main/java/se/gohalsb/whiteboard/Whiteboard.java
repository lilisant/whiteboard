package se.gohalsb.whiteboard;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Whiteboard {
	private static int highestKey = 1;

	protected static Set<PostIt> postIts = Collections
			.synchronizedSet(new HashSet<PostIt>());

	public Whiteboard() {

	}

	public static void addPostIt(PostIt postIt) {
		System.out.println("Add a postIt in Whiteboard");

		postIt.setId(highestKey);
		highestKey++;
		postIts.add(postIt);
	}

	public static void upPostIt(PostIt postIt) {

		System.out.println("Update a postIt in Whiteboard");

		for (PostIt postit : postIts) {
			if (postit.getId() == postIt.getId()) {
				postit.set(postIt);
				break;
			}
		}
	}

	public static void delePostIt(int id) {
		System.out.println("Delete a postIt in Whiteboard");

		for (PostIt postit : postIts) {
			if (postit.getId() == id) {
				System.out.println("Found a postIt in DeletePostIt, title="
						+ postit.getTitle());
				postIts.remove(postit);
				break;
			}
		}
	}
}
