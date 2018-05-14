package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class EndpointsAsyncTaskTest {

/*    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    private EndpointsAsyncTask endpointsAsyncTask;
    private IdlingResource mIdlingResource;

    public void initAsynkTaskandIdlingResource(){
        Context context = getInstrumentation().getTargetContext();
        endpointsAsyncTask = new EndpointsAsyncTask(context, null);
        mIdlingResource = endpointsAsyncTask.getSimpleIdlingResource();
        IdlingRegistry.getInstance().register(mIdlingResource);
    }

    @Test
    public void onPostExecute() {
        initAsynkTaskandIdlingResource();
        onView(withId(R.id.joke_textview)).check(matches(isDisplayed()));

    }

    // Unregister IdlingResource resources when not needed to avoid malfunction
    @After
    public void unregisterIdlingResource() {
        if (mIdlingResource != null) {
            IdlingRegistry.getInstance().unregister(mIdlingResource);
        }
    }*/


    @Test
    public void testVerifyJoke() throws InterruptedException {
        assertTrue(true);
        final CountDownLatch latch = new CountDownLatch(1);
        Context context = InstrumentationRegistry.getContext();
        EndpointsAsyncTask testTask = new EndpointsAsyncTask(context, null) {
            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                if (result != null){
                    assertTrue(result.length() > 0);
                    latch.countDown();
                }
            }
        };
        testTask.execute();
        latch.await();
    }

}