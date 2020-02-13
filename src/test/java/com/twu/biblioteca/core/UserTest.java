package com.twu.biblioteca.core;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

class UserTest {
    String libraryNumber = "1323";
    String password = "212";

    @Test
    public void shouldEquateTwoUsers(){
        User userOne = new User(password, libraryNumber);
        User userTwo = new User(password, libraryNumber);

        assertThat(userOne,is(equalTo(userTwo)));
        assertThat(userOne.hashCode(),is(equalTo(userTwo.hashCode())));
    }
}