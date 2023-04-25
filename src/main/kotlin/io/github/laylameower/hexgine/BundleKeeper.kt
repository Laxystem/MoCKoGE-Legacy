package io.github.laylameower.hexgine

@Deprecated("temporary solution, shouldn't be a registry", level = DeprecationLevel.WARNING)
object BundleKeeper : Iterable<Map.Entry<String, Bundle>> {
    private val contents = mutableMapOf<String, Bundle>()

    internal operator fun set(namespace: String, value: Bundle) =
        if (!contents.containsKey(namespace) && !contents.containsValue(value)) contents[namespace] = value else Unit

    operator fun get(namespace: String) = contents[namespace]
    override fun iterator() = contents.iterator()
}