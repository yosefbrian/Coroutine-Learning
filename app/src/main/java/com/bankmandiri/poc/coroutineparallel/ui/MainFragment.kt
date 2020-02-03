package com.bankmandiri.poc.coroutineparallel.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bankmandiri.poc.coroutineparallel.BaseApp

import com.bankmandiri.poc.coroutineparallel.R
import com.bankmandiri.poc.coroutineparallel.ui.adapter.AuthorAdapter
import com.bankmandiri.poc.coroutineparallel.ui.adapter.MainAdapter
import com.bankmandiri.poc.coroutineparallel.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    private val activitiyAdapter = MainAdapter()
    private val authorAdapter = AuthorAdapter()
    private val bookAdapter = MainAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as BaseApp).appComponent.inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rvActivity.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvActivity.adapter = activitiyAdapter

        rvAuthor.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvAuthor.adapter = authorAdapter

        rvBook.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvBook.adapter = bookAdapter

        initObserver()
        initReloadClick()
        viewModel.getActivities()
        viewModel.getAuthors()
        viewModel.getBooks()
        viewModel.getBook()
    }

    private fun initObserver(){
        viewModel.activityData.observe(viewLifecycleOwner, Observer {
            activitiyAdapter.updateData(it)
        })

        viewModel.authorData.observe(viewLifecycleOwner, Observer {
            authorAdapter.updateData(it)
        })

        viewModel.bookData.observe(viewLifecycleOwner, Observer {
            bookAdapter.updateData(it)
        })

        viewModel.book.observe(viewLifecycleOwner, Observer {
            if (it.title.isNotEmpty()) {
                progress.visibility = View.GONE
                cardView1.visibility = View.VISIBLE
                cardView1.text = it.title
            }
        })
    }


    private fun initReloadClick(){
        reload.setOnClickListener {
            viewModel.getBook()
        }
    }
}
