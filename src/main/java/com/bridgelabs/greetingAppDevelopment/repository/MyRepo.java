package com.bridgelabs.greetingAppDevelopment.repository;

import com.bridgelabs.greetingAppDevelopment.model.Mymodel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepo extends JpaRepository <Mymodel ,Long> {

}
