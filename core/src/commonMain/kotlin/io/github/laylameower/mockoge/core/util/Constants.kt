package io.github.laylameower.mockoge.core.util

public const val mockoge: String = "mockoge"

public const val root: String = "root"
public const val cache: String = "cache"
public const val components: String = "components"
public const val events: String = "events"
public const val loaders: String = "loaders"
public const val parsers: String = "parsers"
public const val scenes: String = "scenes"

public const val inputEvent: String = "input/standard"
public const val preUpdateEvent: String = "update/pre"
public const val updateEvent: String = "update/standard"
public const val postUpdateEvent: String = "update/post"
public const val preTickEvent: String = "update/pre_tick"
public const val tickEvent: String = "update/tick"
public const val postTickEvent: String = "update/post_tick"
public const val preRenderEvent: String = "render/pre"
public const val disposeEvent: String = "dispose"

public const val bundleDirectory: String = "bundles"
public const val cacheDirectory: String = cache
public const val logDirectory: String = "logs"

public const val mockogeFile: String = mockoge
public const val kotlinScriptFile: String = "kts"
public const val assetFile: String = "asset.$kotlinScriptFile"
public const val assetMetadataFile: String = "asset_metadata.$kotlinScriptFile"
public const val bundleFile: String = "bundle.$kotlinScriptFile"
public const val cacheFile: String = "${mockoge}_$cache"
public const val sceneFile: String = "scene.$kotlinScriptFile"
