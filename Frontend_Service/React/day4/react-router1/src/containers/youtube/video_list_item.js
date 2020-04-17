import React from 'react';


const VideoListItem = ({ video, onVideoSelect }) => {

    const imageUrl = video.snippet.thumbnails.default.url;
    //console.log(imageUrl);
    return (
        <li onClick={() => onVideoSelect(video)} className="list-group-item">
            <div className="video-list media">
                <div className="media-left">
                    <img className="media-object" src={imageUrl} />
                </div>
                <div className='media-body'>
                    <div className='media-heading'>
                        {video.snippet.title}
                    </div>
                </div>
            </div>
            {video.snippet.title}
        </li>
    )
}

export default VideoListItem;