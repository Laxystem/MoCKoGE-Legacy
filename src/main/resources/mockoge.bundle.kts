import io.github.laylameower.mockoge.CacheRegistry
import io.github.laylameower.mockoge.SceneRegistry
import io.github.laylameower.mockoge.component.ComponentRegistry
import io.github.laylameower.mockoge.component.Transform3DComponent
import io.github.laylameower.mockoge.component.TransformUIComponent
import io.github.laylameower.mockoge.event.EventRegistry
import io.github.laylameower.mockoge.event.EventType
import io.github.laylameower.mockoge.loader.ResourceLoaderRegistry
import io.github.laylameower.mockoge.loader.ResourceParserRegistry
import kotlin.reflect.full.createType

version = "$version".asVersion
name = "MoCKoGE"


registries {
    cache to CacheRegistry
    components to ComponentRegistry
    events to EventRegistry
    loaders to ResourceLoaderRegistry
    parsers to ResourceParserRegistry
    scenes to SceneRegistry
}

definitions {
    mockoge {
        components {
            "transform" to Transform3DComponent
            "ui" to TransformUIComponent
        }

        events {
            "on_input" to EventType()
            "pre_update" to EventType(parameter = Double::class.createType())
            "pre_tick" to EventType()
            "tick" to EventType()
            "post_tick" to EventType()
            "update" to EventType(parameter = Double::class.createType())
            "post_update" to EventType(parameter = Double::class.createType())
            "pre_render" to EventType()
            "close" to EventType()
        }

        cache {
            events to EventType
        }
    }
}
