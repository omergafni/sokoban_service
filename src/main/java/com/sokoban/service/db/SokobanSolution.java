package com.sokoban.service.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="SokobanSolutions")
public class SokobanSolution {

    @Id
    @Column(name="level_name")
    private String levelName;
    @Column(name="solution")
    private String solution;

    public SokobanSolution(){}

    public SokobanSolution(String levelName, String solution) {
        super();
        this.levelName = levelName;
        this.solution = solution;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }


}
