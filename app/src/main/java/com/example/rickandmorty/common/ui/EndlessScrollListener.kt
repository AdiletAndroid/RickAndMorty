package com.example.rickandmorty.common.ui

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val VISIBLE_THRESHOLD = 10

class EndlessScrollListener(
    private val layoutManager: LinearLayoutManager,
    private val loadNextPage: (Int) -> Unit,
    private val hasMore: Boolean
) : RecyclerView.OnScrollListener() {

    private var page = 1

    private var isLoading = true
    private var totalLoadedItems = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItem = layoutManager.findFirstVisibleItemPosition()

        if (totalItemCount == visibleItemCount) return

        if (totalItemCount > totalLoadedItems) {
            isLoading = false
            totalLoadedItems = totalItemCount
            return
        }

        val smth = totalItemCount - visibleItemCount <= firstVisibleItem + VISIBLE_THRESHOLD
        if (!isLoading && smth) {
            ++page
            loadNextPage(page)
            isLoading = true
        }
    }

    fun reset() {
        isLoading = false
        totalLoadedItems = 0
    }
}