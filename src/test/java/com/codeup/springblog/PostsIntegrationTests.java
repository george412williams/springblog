package com.codeup.springblog;


import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//junit ver 4
@SpringBootTest(classes = SpringblogApplication.class)
@AutoConfigureMockMvc
public class PostsIntegrationTests {

    //@Autowired can be used as the constructor, here must bc cannot inject here

    //@Before, a thing that runs before everything; here create

    //setup public void

        //if statment for users setup and connection to the dao

    //this.httpsession; sending post request to login, sending in params

    //tons of imports w ide help of course; example will have its imports to check against
        //commentd out imports to show what are depending on them, lots
        //also a pattern to make assertions, expects:  .andExpect(...
        //has redirect expect statement, current config is "/posts",
        //.andReturn gives back result of mvc request
        //.getRequest();
        //.getSession(); last thing captured, once avail as instance field,
            //is avail in all other stests
            //currently testing for things that auth user can do

    //create test user if not extis
    //then logging in

    //any post requsts that need to be valid need a particlue scrf token provide by ____
        //to show about token ran site
        //on page inspect, elements under form you see the input w name="csrf
            //the hash value is to prevent something requesting when not on or signed in to the site
            //prevents things like fetch requests written from other places
    //tests are using mock mvc commands

    //several smaller tests; one loads the preexisting mvc context after the session
        //was grabbed in the @Before
        //only post requests need the csrf token

    //has a test that adds a thing to test create

    //actuall tesing part is:  .andExpect(status().is3xxRedirection());
        //when things go right, should be redirected in general,
        //if something went wrong no redirect
        //this thing occurs on successful fx

    //testAdshow was for specific ad
        //upon request, it is run thru the testAdShow() statemtents
        //success runs all statemtns, failure runs none

    //testAdView...

    //edit more complex; edits specific ad/post, once done, expecting redirect (one way to verify process wo error)
        //then ads info

    //delete: create separate ad/post to test and delete with, then get by title,
        //difficult for test to get id from a thing it made for the test
        //gotten w token
        //then the redirect expectation statement

    //output in Run, failures come with information, success is single line validations

    //closes on its own after running, won't get in the way later

    //may have to delete extra created records

    

//see example for body

    //NOTES

    //considerations

    //authorizations in the particular sites
    //encode

}
