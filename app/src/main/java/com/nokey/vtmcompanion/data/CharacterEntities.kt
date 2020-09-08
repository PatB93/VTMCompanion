package com.nokey.vtmcompanion.data

import androidx.annotation.StringRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.nokey.vtmcompanion.R
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.security.InvalidParameterException

@Entity
class Character(
    val characterName: String,
    val sireName: String,
    val selectedClan: Clan,
    val skills: DistributionTypes,
    val attributes: List<Attributes>,
    val disciplines: List<Discipline>
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

class CharacterConverters {
    private val moshi: Moshi = Moshi.Builder()
        .add(PolymorphicJsonAdapterFactory.of(Attributes::class.java, "nameRes")
            .withSubtype(Attributes.Strength::class.java, "strength")
            .withSubtype(Attributes.Dexterity::class.java, "dexterity")
            .withSubtype(Attributes.Stamina::class.java, "stamina")
            .withSubtype(Attributes.Charisma::class.java, "charisma")
            .withSubtype(Attributes.Manipulation::class.java, "manipulation")
            .withSubtype(Attributes.Composure::class.java, "composure")
            .withSubtype(Attributes.Intelligence::class.java, "intelligence")
            .withSubtype(Attributes.Wits::class.java, "wits")
            .withSubtype(Attributes.Resolve::class.java, "resolve"))
        .add(KotlinJsonAdapterFactory())
        .build()

    @TypeConverter
    @StringRes
    fun clanToInt(clan: Clan): Int {
        return clan.stringRes
    }

    @TypeConverter
    fun intToClan(@StringRes res: Int): Clan {
        for (clan: Clan in Clan.values()) {
            if (clan.stringRes == res) {
                return clan
            }
        }
        throw InvalidParameterException("No value for $res in Clan enum")
    }

    @TypeConverter
    fun skillDistributionToJson(skills: DistributionTypes): String {
        val adapter = moshi.adapter(DistributionTypes::class.java)
        return adapter.toJson(skills)
    }

    @TypeConverter
    fun jsonToSkillDistributions(json: String): DistributionTypes? {
        val adapter = moshi.adapter(DistributionTypes::class.java)
        return adapter.fromJson(json)
    }

    @TypeConverter
    fun attributesToJson(attributes: List<Attributes>): String {
        val type = Types.newParameterizedType(List::class.java, Attributes::class.java)
        val adapter = moshi.adapter<List<Attributes>>(type)
        return adapter.toJson(attributes)
    }

    @TypeConverter
    fun jsonToAttributes(attributes: String): List<Attributes>? {
        val type = Types.newParameterizedType(List::class.java, Attributes::class.java)
        val adapter = moshi.adapter<List<Attributes>>(type)
        return adapter.fromJson(attributes)
    }

    @TypeConverter
    fun disciplinesToJson(disciplines: List<Discipline>): String {
        val type = Types.newParameterizedType(List::class.java, Discipline::class.java)
        val adapter = moshi.adapter<List<Discipline>>(type)
        return adapter.toJson(disciplines)
    }

    @TypeConverter
    fun jsonToDiscipline(disciplines: String): List<Discipline>? {
        val type = Types.newParameterizedType(List::class.java, Discipline::class.java)
        val adapter = moshi.adapter<List<Discipline>>(type)
        return adapter.fromJson(disciplines)
    }
}
