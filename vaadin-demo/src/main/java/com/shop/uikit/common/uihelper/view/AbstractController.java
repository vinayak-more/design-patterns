/**
 * @author Vinayak More
 *
 * @date 24-Nov-2016
 */
package com.shop.uikit.common.uihelper.view;

@SuppressWarnings({"rawtypes","unchecked"})
public abstract class AbstractController<V extends AbstractView<?>> {
    private AbstractView v;

    public void onViewEnter(AbstractView v) {
        this.v = v;
        onViewEnter();
    }

    public abstract void onViewEnter();

    public V getView() {
        return (V) v;
    }
}
