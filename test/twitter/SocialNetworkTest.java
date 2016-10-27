package twitter;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class SocialNetworkTest {

    /*
     * TODO: your testing strategies for these methods should go here.
     * Make sure you have partitions.
     */
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testGuessFollowsGraphEmpty() {
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(new ArrayList<>());
        
        assertTrue("expected empty graph", followsGraph.isEmpty());
    }
    
    @Test
    public void testInfluencersEmpty() {
        Map<String, Set<String>> followsGraph = new HashMap<>();
        List<String> influencers = SocialNetwork.influencers(followsGraph);
        
        assertTrue("expected empty list", influencers.isEmpty());
    }

    @Test
    public void testInfluencersSomeInfluencers() throws Exception {
        Map<String, Set<String>> followsGraph = new HashMap<>();
        Set<String> s1 = new HashSet<>(Arrays.asList("a", "c"));
        Set<String> s2 = new HashSet<>(Arrays.asList("b", "c"));
        Set<String> s3 = new HashSet<>(Arrays.asList("a", "c"));
        followsGraph.put("a", s1);
        followsGraph.put("b", s2);
        followsGraph.put("c", s3);

        List<String> influencers = SocialNetwork.influencers(followsGraph);

        assertFalse("expected non-empty list", influencers.isEmpty());
        assertTrue("expected list to contain tweets", influencers.containsAll(Arrays.asList("c", "a", "b")));
    }


    /*
     * Warning: all the tests you write here must be runnable against any
     * SocialNetwork class that follows the spec. It will be run against several
     * staff implementations of SocialNetwork, which will be done by overwriting
     * (temporarily) your version of SocialNetwork with the staff's version.
     * DO NOT strengthen the spec of SocialNetwork or its methods.
     * 
     * In particular, your test cases must not call helper methods of your own
     * that you have put in SocialNetwork, because that means you're testing a
     * stronger spec than SocialNetwork says. If you need such helper methods,
     * define them in a different class. If you only need them in this test
     * class, then keep them in this test class.
     */


    /* Copyright (c) 2016 MIT 6.005 course staff, all rights reserved.
     * Redistribution of original or derived work requires explicit permission.
     * Don't post any of this code on the web or to a public Github repository.
     */
}
