import React from 'react';
import MelonItem from './MelonItem';
import './MelonList.css';

const MelonList = ({musics,onLike,onOpen}) => {
    return (
        <div className='MelonList'>
            <table>
                <colgroup>
                    <col className='w1'/>
                    <col className='w2'/>
                    <col className='w3'/>
                    <col className='w4'/>
                    <col className='w5'/>
                    <col className='w6'/>
                </colgroup>
                <thead>
                    <tr>
                        <td>순위</td>
                        <td>곡(가수)</td>
                        <td>앨범</td>
                        <td>좋아요</td>
                        <td>동영상</td>
                        <td>상승/하락</td>
                    </tr>
                </thead>
                <tbody>
                    {
                        musics.map(music => <MelonItem key={music.id}
                            music={music} onLike={onLike} onOpen={onOpen}/>)
                    }
                </tbody>
            </table>
        </div>
    );
};

export default MelonList;