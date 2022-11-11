import AudioPlayer from 'react-h5-audio-player';
import 'react-h5-audio-player/lib/styles.css';
// import 'react-h5-audio-player/lib/styles.less' Use LESS
// import 'react-h5-audio-player/src/styles.scss' Use SASS

export const Player = () => (
  <AudioPlayer
    autoPlay
    src='../../musica/How I Became the Sea _ 24Naijamuzic.com - cópia.mp3'
    onPlay={(e) => console.log('onPlay')}
    // other props here
  />
);
