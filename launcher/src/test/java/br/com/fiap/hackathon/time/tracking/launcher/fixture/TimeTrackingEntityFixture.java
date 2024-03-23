package br.com.fiap.hackathon.time.tracking.launcher.fixture;

import br.com.fiap.hackathon.time.tracking.driven.mongo.model.DBTimeTrackingEntry;
import br.com.fiap.hackathon.time.tracking.driven.mongo.model.TimeTrackingEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeTrackingEntityFixture {

    public static Model<TimeTrackingEntity> timeTrackingEntityModel() {
        return Instancio.of(TimeTrackingEntity.class)
                .set(field(TimeTrackingEntity::getEmployeeId), "102031")
                .set(field(TimeTrackingEntity::getDate), LocalDate.now())
                .generate(field(TimeTrackingEntity::getUuid), gen -> gen.text().uuid())
                .set(field(TimeTrackingEntity::getEntries), Instancio.ofList(dbTimeTrackingEntryModel()).size(7).create())
                .toModel();
    }

    public static Model<DBTimeTrackingEntry> dbTimeTrackingEntryModel() {
        return Instancio.of(DBTimeTrackingEntry.class)
                .generate(field(DBTimeTrackingEntry::getUuid), gen -> gen.text().uuid())
                .generate(field(DBTimeTrackingEntry::getTimestamp), gen -> gen.temporal().localDateTime().range(LocalDate.now().atStartOfDay(), LocalDate.now().atTime(LocalTime.MAX)))
                .toModel();
    }

}
