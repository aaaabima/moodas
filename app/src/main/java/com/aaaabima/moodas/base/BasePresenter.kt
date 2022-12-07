/*
 * DANA.id
 * PT. Espay Debit Indonesia Koe.
 * Copyright (c) 2017-2022 All Rights Reserved.
 */

package com.aaaabima.moodas.base

/**
 * @author Abim (Moch Arya Bima A) (i-arya.agfian@dana.id)
 * @version BasePresenter, v 0.1 06/12/22 15.35 by Abim (Moch Arya Bima A)
 */
/**
* Interface representing a Presenter in a model view presenter (MVP) pattern.
* Credit by: https://github.com/aderayanbima31/Movie-OnBoardingApp
*/
interface BasePresenter {

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    fun resume()

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    fun pause()

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    fun destroy()
}