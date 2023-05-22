package edu.sru.thangiah.datastructures.tree.twothreefourtree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoThreeFourTreeIntTest {

	TwoThreeFourTreeInt rightLeaning = new TwoThreeFourTreeInt();
	TwoThreeFourTreeInt leftLeaning = new TwoThreeFourTreeInt();
	TwoThreeFourTreeInt filled = new TwoThreeFourTreeInt();
	
	@BeforeEach
	void setUp() throws Exception {
		
		rightLeaning.add(5);
		rightLeaning.add(6);
		rightLeaning.add(7);
		rightLeaning.add(8);
		rightLeaning.add(9);
		rightLeaning.add(10);

		leftLeaning.add(10);
		leftLeaning.add(9);
		leftLeaning.add(8);
		leftLeaning.add(7);
		leftLeaning.add(6);
		leftLeaning.add(5);

		filled.add(4);
		filled.add(5);
		filled.add(6);
		filled.add(3);
		filled.add(7);
		filled.add(2);
		filled.add(8);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		rightLeaning.clear();
		leftLeaning.clear();
		filled.clear();
		
	}
	
	@Test
	void initializationTest() {
		assertEquals(rightLeaning.getRoot().getType(),2); //nodes split, then split again, so the highest tier has 2 values in it which should be 6, 8
		assertEquals(rightLeaning.getRoot().getValue(0),6);
		assertEquals(rightLeaning.getRoot().getValue(1),8);
		assertEquals(leftLeaning.getRoot().getType(),2); //nodes split, then split again, so the highest tier has 2 values in it, which should be 7, 9
		assertEquals(leftLeaning.getRoot().getValue(0),7);
		assertEquals(leftLeaning.getRoot().getValue(1),9);
		assertEquals(filled.getRoot().getType(),1); //nodes split once, 2,3,4/ROOT 5\6,7,8
	}

}
