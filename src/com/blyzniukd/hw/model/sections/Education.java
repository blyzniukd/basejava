package com.blyzniukd.hw.model.sections;

import com.blyzniukd.hw.model.description.Description;
import com.blyzniukd.hw.model.description.LinkDescription;
import com.blyzniukd.hw.model.description.Period;

import java.time.LocalDate;
import java.util.Objects;

public class Education extends AbstractArraySection<Education.Info> {

    public static final String HEADER = "Образование";

    public Education() {
        super(HEADER);
    }

    public void add(String institution, String link, LocalDate start, LocalDate finish, String description) {
        Info record = new Info(new LinkDescription(institution, link), new Period(start, finish), new Description(description));
        super.add(record);
    }

    class Info {
        private LinkDescription institution;
        private Period period;
        private Description description;

        public Info(LinkDescription institution, Period period, Description description) {
            this.institution = institution;
            this.period = period;
            this.description = description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Info info = (Info) o;
            return Objects.equals(institution, info.institution) &&
                    Objects.equals(period, info.period) &&
                    Objects.equals(description, info.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(institution, period, description);
        }

        @Override
        public String toString() {
            return new StringBuffer().append("Education.Info{")
                    .append("instituition=").append(institution)
                    .append(", period=").append(period)
                    .append(", description=").append(description)
                    .append("}")
                    .toString();
        }
    }
}
