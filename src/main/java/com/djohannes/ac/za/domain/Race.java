package com.djohannes.ac.za.domain;

import java.util.Objects;

public class Race
{
    private String id, race;

    private Race(Builder builder)
    {
        this.id=builder.id;
        this.race=builder.race;
    }

    public String getId()
    {
        return id;
    }

    public String getRace()
    {
        return race;
    }

    public static class Builder
    {
        private String id, race;

        public Builder copy(Race race)
        {
            this.id=race.id;
            this.race=race.race;
            return this;
        }

        public Builder getId(String id)
        {
            this.id=id;
            return this;
        }

        public Builder getRace(String race)
        {
            this.race=race;
            return this;
        }

        public Race build()
        {
            return new Race(this);
        }
    }

    @Override
    public String toString() {
        return "Race{" +
                "Id='" + id + '\'' +
                "Race='" + race + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return id.equals(race.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
