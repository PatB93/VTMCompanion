package com.nokey.vtmcompanion.data

import androidx.annotation.StringRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
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
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}

class CharacterConverters {
    private val moshi: Moshi = Moshi.Builder()
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
    fun attributeToJson(attributes: List<Attributes>): String {
        val adapter = moshi.adapter(List::class.java)
        return adapter.toJson(attributes)
    }

    @TypeConverter
    fun jsonToAttributes(json: String): List<Attributes>? {
        val type = Types.newParameterizedType(
            List::class.java,
            Attributes::class.java
        )
        val adapter = moshi.adapter<List<Attributes>>(type)
        return adapter.fromJson(json)
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
