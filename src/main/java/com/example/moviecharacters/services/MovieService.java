package com.example.moviecharacters.services;

import com.example.moviecharacters.models.Movie;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.boot.model.source.internal.hbm.ModelBinder;

public interface MovieService extends CrudService<Movie, Integer> {


}
