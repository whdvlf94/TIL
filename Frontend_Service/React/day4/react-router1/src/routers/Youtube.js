import React, { Component } from 'react';
import YTSearch from 'youtube-api-search'
import _ from 'lodash';
import SearchBar from '../containers/youtube/search_bar';
import VideoList from '../containers/youtube/video_list';
import VideoDetail from '../containers/youtube/video_detail';

const API_KEY = 'AIzaSyDhsBfgni4JKKwE0h_WU2hIBxgD28lCwxs';

export default class Youtube extends Component {
  constructor(props) {
    super(props);   // 부모의 생성자 함수를 호출

    this.state = {
      videos: [],
      selectedVideo: null
    }

    this.videoSearch('soccer');
  }

  videoSearch( term ) {
    YTSearch({ key: API_KEY, term: term }, (data) => {
      this.setState({
        videos: data,
        selectedVideo: data[0]
      });
    });
  }

  handleSelect =(selectedVideo) => {
    // 선택된 video를 detail에 표시
    this.setState({
      selectedVideo: selectedVideo
    })
  }

  render() {

    const _videoSearch = _.debounce((term) => {this.videoSearch(term)},300);
    
    return (
      <div>
        <SearchBar onSearchTermChange = {_videoSearch}/>
        <VideoDetail video={this.state.selectedVideo} />
        <VideoList 
          onVideoSelect={this.handleSelect}
          videos={this.state.videos} />
      </div>
    );
  }
}



