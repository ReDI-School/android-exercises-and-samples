package com.cesarvaliente.redisamples.network;

/*
{
    "count": 87,
    "next": "https://swapi.co/api/people/?page=2",
    "previous": null,
    "results": [
        {
            "birth_year": "19BBY",
            "created": "2014-12-09T13:50:51.644000Z",
            "edited": "2014-12-20T21:17:56.891000Z",
            "eye_color": "blue",
            "films": [
                "https://swapi.co/api/films/2/",
                "https://swapi.co/api/films/6/",
                "https://swapi.co/api/films/3/",
                "https://swapi.co/api/films/1/",
                "https://swapi.co/api/films/7/"
            ],
            "gender": "male",
            "hair_color": "blond",
            "height": "172",
            "homeworld": "https://swapi.co/api/planets/1/",
            "mass": "77",
            "name": "Luke Skywalker",
            "skin_color": "fair",
            "species": [
                "https://swapi.co/api/species/1/"
            ],
            "starships": [
                "https://swapi.co/api/starships/12/",
                "https://swapi.co/api/starships/22/"
            ],
            "url": "https://swapi.co/api/people/1/",
            "vehicles": [
                "https://swapi.co/api/vehicles/14/",
                "https://swapi.co/api/vehicles/30/"
            ]
        },
      ....
      ]
   }
 */

import java.util.List;

import com.squareup.moshi.Json;

public class People {

    int count;
    String next;
    String previous;
    @Json(name = "results")
    List<Creature> creatures;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        People people1 = (People) o;

        if (count != people1.count) {
            return false;
        }
        if (next != null ? !next.equals(people1.next) : people1.next != null) {
            return false;
        }
        if (previous != null ? !previous.equals(people1.previous) : people1.previous != null) {
            return false;
        }
        return creatures != null ? creatures.equals(people1.creatures) : people1.creatures == null;

    }

    @Override
    public int hashCode() {
        int result = count;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        result = 31 * result + (previous != null ? previous.hashCode() : 0);
        result = 31 * result + (creatures != null ? creatures.hashCode() : 0);
        return result;
    }
}
