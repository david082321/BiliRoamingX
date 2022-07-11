package app.revanced.integrations.utils

/**
 * generic event provider class
 */
class Event<T> {
    private val eventListeners = mutableSetOf<(T) -> Unit>()

    operator fun plusAssign(observer: (T) -> Unit) {
        eventListeners.add(observer)
    }

    operator fun minusAssign(observer: (T) -> Unit) {
        eventListeners.remove(observer)
    }

    operator fun invoke(value: T) {
        for (observer in eventListeners)
            observer.invoke(value)
    }
}

