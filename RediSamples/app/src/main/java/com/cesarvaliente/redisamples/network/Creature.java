package com.cesarvaliente.redisamples.network;

/*
 "birth_year": "112BBY",
    "created": "2014-12-10T15:10:51.357000Z",
    "edited": "2014-12-20T21:17:50.309000Z",
    "eye_color": "yellow",
    "films": [
        "https://swapi.co/api/films/2/",
        "https://swapi.co/api/films/5/",
        "https://swapi.co/api/films/4/",
        "https://swapi.co/api/films/6/",
        "https://swapi.co/api/films/3/",
        "https://swapi.co/api/films/1/"
    ],
    "gender": "n/a",
    "hair_color": "n/a",
    "height": "167",
    "homeworld": "https://swapi.co/api/planets/1/",
    "mass": "75",
    "name": "C-3PO",
    "skin_color": "gold",
    "species": [
        "https://swapi.co/api/species/2/"
    ],
    "starships": [],
    "url": "https://swapi.co/api/people/2/",
    "vehicles": []
 */

import java.util.List;

import com.squareup.moshi.Json;

public class Creature {

    @Json(name = "birth_year")
    String birthYear;
    String created;
    String edited;

    @Json(name = "eye_color")
    String eyeColor;

    List<String> films;
    String gender;
    @Json(name = "hair_color")
    String hairColor;

    String height;
    String homeworld;
    String mass;
    String name;
    @Json(name = "skin_color")
    String skinColor;
    List<String> species;
    List<String> starships;
    String url;
    List<String> vehicles;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Creature creature = (Creature) o;

        if (birthYear != null ? !birthYear.equals(creature.birthYear) : creature.birthYear != null) {
            return false;
        }
        if (created != null ? !created.equals(creature.created) : creature.created != null) {
            return false;
        }
        if (edited != null ? !edited.equals(creature.edited) : creature.edited != null) {
            return false;
        }
        if (eyeColor != null ? !eyeColor.equals(creature.eyeColor) : creature.eyeColor != null) {
            return false;
        }
        if (films != null ? !films.equals(creature.films) : creature.films != null) {
            return false;
        }
        if (gender != null ? !gender.equals(creature.gender) : creature.gender != null) {
            return false;
        }
        if (hairColor != null ? !hairColor.equals(creature.hairColor) : creature.hairColor != null) {
            return false;
        }
        if (height != null ? !height.equals(creature.height) : creature.height != null) {
            return false;
        }
        if (homeworld != null ? !homeworld.equals(creature.homeworld) : creature.homeworld != null) {
            return false;
        }
        if (mass != null ? !mass.equals(creature.mass) : creature.mass != null) {
            return false;
        }
        if (name != null ? !name.equals(creature.name) : creature.name != null) {
            return false;
        }
        if (skinColor != null ? !skinColor.equals(creature.skinColor) : creature.skinColor != null) {
            return false;
        }
        if (species != null ? !species.equals(creature.species) : creature.species != null) {
            return false;
        }
        if (starships != null ? !starships.equals(creature.starships) : creature.starships != null) {
            return false;
        }
        if (url != null ? !url.equals(creature.url) : creature.url != null) {
            return false;
        }
        return vehicles != null ? vehicles.equals(creature.vehicles) : creature.vehicles == null;

    }

    @Override
    public int hashCode() {
        int result = birthYear != null ? birthYear.hashCode() : 0;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (edited != null ? edited.hashCode() : 0);
        result = 31 * result + (eyeColor != null ? eyeColor.hashCode() : 0);
        result = 31 * result + (films != null ? films.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (hairColor != null ? hairColor.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (homeworld != null ? homeworld.hashCode() : 0);
        result = 31 * result + (mass != null ? mass.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (skinColor != null ? skinColor.hashCode() : 0);
        result = 31 * result + (species != null ? species.hashCode() : 0);
        result = 31 * result + (starships != null ? starships.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (vehicles != null ? vehicles.hashCode() : 0);
        return result;
    }
}
